const API = "http://localhost:8080/api";


// =====================================================
// LOAD DOCTORS
// =====================================================

async function loadDoctors() {

    try {

        const response =
            await fetch(`${API}/doctors`);

        const doctors =
            await response.json();

        console.log("Doctors:", doctors);

        const select =
            document.getElementById("doctorSelect");

        if (select) {

            select.innerHTML =
                `<option value="">Select Doctor</option>`;

            doctors.forEach(doctor => {

                select.innerHTML += `
                    <option value="${doctor.id}">
                        ${doctor.name} - ${doctor.specialization}
                    </option>
                `;
            });
        }

        const container =
            document.getElementById("doctorsContainer");

        if (container) {

            container.innerHTML = "";

            doctors.forEach(doctor => {

                container.innerHTML += `
                    <div class="doctor-card">

                        <h3>${doctor.name}</h3>

                        <p>
                            <strong>Specialization:</strong>
                            ${doctor.specialization}
                        </p>

                        <p>
                            <strong>Department:</strong>
                            ${doctor.department}
                        </p>

                        <p>
                            <strong>Experience:</strong>
                            ${doctor.experience} years
                        </p>

                        <p>
                            <strong>Doctor ID:</strong>
                            ${doctor.id}
                        </p>

                    </div>
                `;
            });
        }

    } catch (error) {

        console.error(error);

        alert(
            "Cannot connect to Java server. Please start HospitalServer.java."
        );
    }
}


// =====================================================
// PATIENT REGISTRATION
// =====================================================

const registerForm =
    document.getElementById("registerForm");

if (registerForm) {

    registerForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const formData =
            new FormData(registerForm);

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(`${API}/register`, {

                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/x-www-form-urlencoded"
                    },

                    body: data
                });

            const result =
                await response.json();

            if (result.success) {

                alert(
                    "Registration successful!\nYour Patient ID is: "
                    + result.patientId
                );

                registerForm.reset();

            } else {

                alert(result.message);
            }

        } catch (error) {

            console.error(error);

            alert("Unable to connect to Java server.");
        }

    });
}


// =====================================================
// PATIENT LOGIN
// =====================================================

const patientLoginForm =
    document.getElementById("patientLoginForm");

if (patientLoginForm) {

    patientLoginForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const formData =
            new FormData(patientLoginForm);

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(`${API}/login/patient`, {

                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/x-www-form-urlencoded"
                    },

                    body: data
                });

            const result =
                await response.json();

            if (result.success) {

                localStorage.setItem(
                    "patientId",
                    result.patientId
                );

                localStorage.setItem(
                    "patientName",
                    result.name
                );

                alert(
                    "Welcome, " + result.name + "!"
                );

            } else {

                alert(result.message);
            }

        } catch (error) {

            console.error(error);

            alert("Unable to connect to Java server.");
        }

    });
}


// =====================================================
// DOCTOR LOGIN
// =====================================================

const doctorLoginForm =
    document.getElementById("doctorLoginForm");

if (doctorLoginForm) {

    doctorLoginForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const formData =
            new FormData(doctorLoginForm);

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(`${API}/login/doctor`, {

                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/x-www-form-urlencoded"
                    },

                    body: data
                });

            const result =
                await response.json();

            if (result.success) {

                localStorage.setItem(
                    "doctorId",
                    result.doctorId
                );

                localStorage.setItem(
                    "doctorName",
                    result.name
                );

                alert(
                    "Welcome Dr. " + result.name
                );

            } else {

                alert(result.message);
            }

        } catch (error) {

            console.error(error);

            alert("Unable to connect to Java server.");
        }

    });
}


// =====================================================
// ADMIN LOGIN
// =====================================================

const adminLoginForm =
    document.getElementById("adminLoginForm");

if (adminLoginForm) {

    adminLoginForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const formData =
            new FormData(adminLoginForm);

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(`${API}/login/admin`, {

                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/x-www-form-urlencoded"
                    },

                    body: data
                });

            const result =
                await response.json();

            if (result.success) {

                localStorage.setItem(
                    "adminLoggedIn",
                    "true"
                );

                alert(
                    "Administrator login successful!"
                );

            } else {

                alert(result.message);
            }

        } catch (error) {

            console.error(error);

            alert("Unable to connect to Java server.");
        }

    });
}


// =====================================================
// BOOK APPOINTMENT
// =====================================================

const appointmentForm =
    document.getElementById("appointmentForm");

if (appointmentForm) {

    appointmentForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const patientId =
            localStorage.getItem("patientId");

        if (!patientId) {

            alert(
                "Please login as a patient first."
            );

            return;
        }

        const formData =
            new FormData(appointmentForm);

        formData.set(
            "patientId",
            patientId
        );

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(
                    `${API}/appointment/book`,
                    {

                        method: "POST",

                        headers: {
                            "Content-Type":
                                "application/x-www-form-urlencoded"
                        },

                        body: data
                    }
                );

            const result =
                await response.json();

            if (result.success) {

                alert(
                    "Appointment booked successfully!\n"
                    + "Appointment ID: "
                    + result.appointmentId
                );

                appointmentForm.reset();

            } else {

                alert(result.message);
            }

        } catch (error) {

            console.error(error);

            alert(
                "Unable to connect to Java server."
            );
        }

    });
}


// =====================================================
// RESCHEDULE
// =====================================================

const rescheduleForm =
    document.getElementById("rescheduleForm");

if (rescheduleForm) {

    rescheduleForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const formData =
            new FormData(rescheduleForm);

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(
                    `${API}/appointment/reschedule`,
                    {

                        method: "POST",

                        headers: {
                            "Content-Type":
                                "application/x-www-form-urlencoded"
                        },

                        body: data
                    }
                );

            const result =
                await response.json();

            alert(result.message);

        } catch (error) {

            console.error(error);

            alert(
                "Unable to connect to Java server."
            );
        }

    });
}


// =====================================================
// CANCEL
// =====================================================

const cancelForm =
    document.getElementById("cancelForm");

if (cancelForm) {

    cancelForm.addEventListener("submit", async function(event) {

        event.preventDefault();

        const formData =
            new FormData(cancelForm);

        const data =
            new URLSearchParams(formData);

        try {

            const response =
                await fetch(
                    `${API}/appointment/cancel`,
                    {

                        method: "POST",

                        headers: {
                            "Content-Type":
                                "application/x-www-form-urlencoded"
                        },

                        body: data
                    }
                );

            const result =
                await response.json();

            alert(result.message);

        } catch (error) {

            console.error(error);

            alert(
                "Unable to connect to Java server."
            );
        }

    });
}


// =====================================================
// VIEW PATIENT APPOINTMENTS
// =====================================================

const viewAppointmentsBtn =
    document.getElementById(
        "viewAppointmentsBtn"
    );

if (viewAppointmentsBtn) {

    viewAppointmentsBtn.addEventListener(
        "click",
        async function() {

            const patientId =
                localStorage.getItem("patientId");

            if (!patientId) {

                alert(
                    "Please login first."
                );

                return;
            }

            try {

                const response =
                    await fetch(
                        `${API}/appointments/patient?patientId=${patientId}`
                    );

                const appointments =
                    await response.json();

                if (appointments.length === 0) {

                    alert(
                        "No appointments found."
                    );

                    return;
                }

                let message =
                    "YOUR APPOINTMENTS\n\n";

                appointments.forEach(a => {

                    message +=
                        "Appointment ID: "
                        + a.id + "\n"
                        + "Doctor: "
                        + a.doctor + "\n"
                        + "Date: "
                        + a.date + "\n"
                        + "Time: "
                        + a.time + "\n"
                        + "Status: "
                        + a.status + "\n\n";
                });

                alert(message);

            } catch (error) {

                console.error(error);

                alert(
                    "Unable to connect to Java server."
                );
            }
        }
    );
}


// =====================================================
// VIEW MEDICAL RECORD
// =====================================================

const viewMedicalRecordBtn =
    document.getElementById(
        "viewMedicalRecordBtn"
    );

if (viewMedicalRecordBtn) {

    viewMedicalRecordBtn.addEventListener(
        "click",
        async function() {

            const patientId =
                localStorage.getItem("patientId");

            if (!patientId) {

                alert(
                    "Please login first."
                );

                return;
            }

            try {

                const response =
                    await fetch(
                        `${API}/record?patientId=${patientId}`
                    );

                const record =
                    await response.json();

                if (!response.ok) {

                    alert(record.message);

                    return;
                }

                alert(
                    "MEDICAL RECORD\n\n"
                    + "Diagnosis: "
                    + record.diagnosis + "\n"
                    + "Prescription: "
                    + record.prescription + "\n"
                    + "Medical History: "
                    + record.history + "\n"
                    + "Date: "
                    + record.date
                );

            } catch (error) {

                console.error(error);

                alert(
                    "Unable to connect to Java server."
                );
            }
        }
    );
}


// =====================================================
// DOCTOR APPOINTMENTS
// =====================================================

const viewDoctorAppointmentsBtn =
    document.getElementById(
        "viewDoctorAppointmentsBtn"
    );

if (viewDoctorAppointmentsBtn) {

    viewDoctorAppointmentsBtn.addEventListener(
        "click",
        async function() {

            const doctorId =
                localStorage.getItem("doctorId");

            if (!doctorId) {

                alert(
                    "Please login as doctor first."
                );

                return;
            }

            try {

                const response =
                    await fetch(
                        `${API}/appointments/doctor?doctorId=${doctorId}`
                    );

                const appointments =
                    await response.json();

                if (appointments.length === 0) {

                    alert(
                        "No appointments found."
                    );

                    return;
                }

                let message =
                    "DOCTOR APPOINTMENTS\n\n";

                appointments.forEach(a => {

                    message +=
                        "Appointment ID: "
                        + a.id + "\n"
                        + "Patient: "
                        + a.patient + "\n"
                        + "Date: "
                        + a.date + "\n"
                        + "Time: "
                        + a.time + "\n"
                        + "Status: "
                        + a.status + "\n\n";
                });

                alert(message);

            } catch (error) {

                console.error(error);

                alert(
                    "Unable to connect to Java server."
                );
            }
        }
    );
}


// =====================================================
// ADMIN REPORT
// =====================================================

const generateReportBtn =
    document.getElementById(
        "generateReportBtn"
    );

if (generateReportBtn) {

    generateReportBtn.addEventListener(
        "click",
        async function() {

            try {

                const response =
                    await fetch(
                        `${API}/admin/report`
                    );

                const report =
                    await response.json();

                alert(
                    "HOSPITAL REPORT\n\n"
                    + "Hospital: "
                    + report.hospital + "\n"
                    + "Patients: "
                    + report.patients + "\n"
                    + "Doctors: "
                    + report.doctors + "\n"
                    + "Appointments: "
                    + report.appointments + "\n"
                    + "Medical Records: "
                    + report.records
                );

            } catch (error) {

                console.error(error);

                alert(
                    "Unable to connect to Java server."
                );
            }
        }
    );
}


// =====================================================
// START
// =====================================================

document.addEventListener(
    "DOMContentLoaded",
    function() {

        loadDoctors();

    }
);