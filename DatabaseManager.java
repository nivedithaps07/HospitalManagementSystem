/* =========================================================
   CITY CARE HOSPITAL
   MAIN WEBSITE JAVASCRIPT
   ========================================================= */

const API = "http://localhost:8080/api";


/* ---------- Show and hide forms ---------- */

function hideForms() {
    document.querySelectorAll(".form-section")
        .forEach(section => section.classList.add("hidden"));
}

function showSection(id) {
    hideForms();

    const section = document.getElementById(id);

    if (section) {
        section.classList.remove("hidden");

        section.scrollIntoView({
            behavior: "smooth",
            block: "start"
        });
    }
}

function showLoginChooser() {
    showSection("login-chooser");
}


/* ---------- API helpers ---------- */

async function apiRequest(url, options = {}) {

    const response = await fetch(url, options);
    const result = await response.json();

    if (!response.ok) {
        throw new Error(
            result.message || "Request failed."
        );
    }

    return result;
}

function formBody(form) {
    return new URLSearchParams(new FormData(form));
}

function postForm(form) {
    return {
        method: "POST",

        headers: {
            "Content-Type":
                "application/x-www-form-urlencoded"
        },

        body: formBody(form)
    };
}


/* =========================================================
   PAGE STARTUP
   ========================================================= */

document.addEventListener("DOMContentLoaded", () => {

    loadDoctors();


    /* ---------- Patient registration ---------- */

    const registerForm =
        document.getElementById("registerForm");

    registerForm.addEventListener("submit", async event => {

        event.preventDefault();

        try {

            const result = await apiRequest(
                `${API}/register`,
                postForm(registerForm)
            );

            alert(
                `Registration successful!\n` +
                `Your Patient ID is: ${result.patientId}\n` +
                `Please keep this ID to log in.`
            );

            registerForm.reset();

            document.getElementById("patientLoginId").value =
                result.patientId;

            showSection("patient-login");

        } catch (error) {

            alert(
                error.message +
                "\nCheck that HospitalServer is running."
            );
        }
    });


    /* ---------- Patient login ---------- */

    const patientLoginForm =
        document.getElementById("patientLoginForm");

    patientLoginForm.addEventListener("submit", async event => {

        event.preventDefault();

        try {

            const result = await apiRequest(
                `${API}/login/patient`,
                postForm(patientLoginForm)
            );

            localStorage.setItem(
                "patientId",
                result.patientId
            );

            localStorage.setItem(
                "patientName",
                result.name
            );

            window.location.href = "patient-dashboard.html";

        } catch (error) {

            alert(error.message);
        }
    });


    /* ---------- Doctor login ---------- */

    const doctorLoginForm =
        document.getElementById("doctorLoginForm");

    doctorLoginForm.addEventListener("submit", async event => {

        event.preventDefault();

        try {

            const result = await apiRequest(
                `${API}/login/doctor`,
                postForm(doctorLoginForm)
            );

            localStorage.setItem(
                "doctorId",
                result.doctorId
            );

            localStorage.setItem(
                "doctorName",
                result.name
            );

            window.location.href = "doctor-dashboard.html";

        } catch (error) {

            alert(error.message);
        }
    });


    /* ---------- Administrator login ---------- */

    const adminLoginForm =
        document.getElementById("adminLoginForm");

    adminLoginForm.addEventListener("submit", async event => {

        event.preventDefault();

        try {

            await apiRequest(
                `${API}/login/admin`,
                postForm(adminLoginForm)
            );

            localStorage.setItem(
                "adminLoggedIn",
                "true"
            );

            window.location.href = "admin-dashboard.html";

        } catch (error) {

            alert(error.message);
        }
    });

});


/* =========================================================
   LOAD DOCTORS FROM DATABASE
   ========================================================= */

async function loadDoctors() {

    const container =
        document.getElementById("doctorsContainer");

    try {

        const doctors = await apiRequest(
            `${API}/doctors`
        );

        if (!doctors.length) {

            container.innerHTML =
                '<p class="empty-state">No doctors are listed yet.</p>';

            return;
        }

        container.innerHTML = doctors.map(doctor => `
            <article class="doctor-profile">

                <div class="doctor-image">👨‍⚕️</div>

                <h3>${escapeHtml(doctor.name)}</h3>

                <p>${escapeHtml(doctor.specialization)}</p>

                <span>
                    ${escapeHtml(doctor.department)}
                    · ${doctor.experience} years
                </span>

                <p class="doctor-id">
                    Doctor ID: ${doctor.id}
                </p>

                <button type="button"
                        onclick="showSection('patient-login')">
                    Patient Login to Book
                </button>

            </article>
        `).join("");

    } catch (error) {

        container.innerHTML =
            '<p class="error-state">' +
            'Cannot load the doctor list. Start the Java server and refresh.' +
            '</p>';

        console.error(error);
    }
}


/* =========================================================
   ESCAPE HTML TEXT
   ========================================================= */

function escapeHtml(value) {

    return String(value ?? "")
        .replaceAll("&", "&amp;")
        .replaceAll("<", "&lt;")
        .replaceAll(">", "&gt;")
        .replaceAll('"', "&quot;")
        .replaceAll("'", "&#039;");
}