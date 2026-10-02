import java.util.ArrayList;
import java.util.Scanner;

/*
 * HOSPITAL APPOINTMENT AND PATIENT MANAGEMENT SYSTEM
 * OOP MICROPROJECT
 *
 * Concepts demonstrated:
 * 1. Class and Objects
 * 2. Encapsulation
 * 3. Inheritance
 * 4. Polymorphism
 * 5. Association
 * 6. ArrayList
 */

// =====================================================
// PERSON CLASS - PARENT CLASS
// =====================================================

class Person {

    private int id;
    private String name;
    private String phone;
    private String email;

    // Constructor
    public Person(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to demonstrate polymorphism
    public void displayDetails() {
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Phone    : " + phone);
        System.out.println("Email    : " + email);
    }
}


// =====================================================
// PATIENT CLASS - CHILD CLASS
// =====================================================

class Patient extends Person {

    private int patientId;
    private String disease;
    private String address;
    private String bloodGroup;
    private String emergencyContact;

    public Patient(
            int patientId,
            String name,
            String phone,
            String email,
            String disease,
            String address,
            String bloodGroup,
            String emergencyContact) {

        super(patientId, name, phone, email);

        this.patientId = patientId;
        this.disease = disease;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDisease() {
        return disease;
    }

    public String getAddress() {
        return address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    // Patient registration
    public void registerPatient() {
        System.out.println("Patient registered successfully.");
    }

    // Book appointment
    public void bookAppointment() {
        System.out.println("Appointment booking option selected.");
    }

    // Cancel appointment
    public void cancelAppointment() {
        System.out.println("Appointment cancellation option selected.");
    }

    // View medical record
    public void viewMedicalRecord() {
        System.out.println("Medical record viewing option selected.");
    }

    // Overriding parent method - POLYMORPHISM
    @Override
    public void displayDetails() {

        System.out.println("\n---------- PATIENT DETAILS ----------");
        System.out.println("Patient ID       : " + patientId);
        System.out.println("Name             : " + getName());
        System.out.println("Phone            : " + getPhone());
        System.out.println("Email            : " + getEmail());
        System.out.println("Disease          : " + disease);
        System.out.println("Address          : " + address);
        System.out.println("Blood Group      : " + bloodGroup);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("-------------------------------------");
    }
}


// =====================================================
// DOCTOR CLASS - CHILD CLASS
// =====================================================

class Doctor extends Person {

    private int doctorId;
    private String specialization;
    private String department;
    private int experience;

    public Doctor(
            int doctorId,
            String name,
            String phone,
            String email,
            String specialization,
            String department,
            int experience) {

        super(doctorId, name, phone, email);

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.department = department;
        this.experience = experience;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperience() {
        return experience;
    }

    // View appointments
    public void viewAppointments() {
        System.out.println("Doctor can view appointments.");
    }

    // View patient information
    public void viewPatientDetails(int patientId) {
        System.out.println("Viewing patient information for Patient ID: "
                + patientId);
    }

    // Update medical record
    public void updateMedicalRecord(int patientId, MedicalRecord record) {
        System.out.println("Medical record updated for Patient ID: "
                + patientId);
    }

    // Overriding parent method - POLYMORPHISM
    @Override
    public void displayDetails() {

        System.out.println("\n---------- DOCTOR DETAILS ----------");
        System.out.println("Doctor ID       : " + doctorId);
        System.out.println("Name            : " + getName());
        System.out.println("Phone           : " + getPhone());
        System.out.println("Email           : " + getEmail());
        System.out.println("Specialization  : " + specialization);
        System.out.println("Department      : " + department);
        System.out.println("Experience      : " + experience + " years");
        System.out.println("------------------------------------");
    }
}


// =====================================================
// APPOINTMENT CLASS
// =====================================================

class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private String status;

    public Appointment(
            int appointmentId,
            Patient patient,
            Doctor doctor,
            String date,
            String time) {

        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.status = "Booked";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    // Book appointment
    public void bookAppointment() {
        status = "Booked";
    }

    // Cancel appointment
    public void cancelAppointment() {
        status = "Cancelled";
    }

    // Reschedule appointment
    public void rescheduleAppointment(String newDate, String newTime) {
        date = newDate;
        time = newTime;
        status = "Rescheduled";
    }

    // Display appointment
    public void displayAppointment() {

        System.out.println("\n---------- APPOINTMENT ----------");
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient        : " + patient.getName());
        System.out.println("Doctor         : " + doctor.getName());
        System.out.println("Specialization : " + doctor.getSpecialization());
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Status         : " + status);
        System.out.println("---------------------------------");
    }
}


// =====================================================
// MEDICAL RECORD CLASS
// =====================================================

class MedicalRecord {

    private int recordId;
    private int patientId;
    private String diagnosis;
    private String prescription;
    private String medicalHistory;
    private String recordDate;

    public MedicalRecord(
            int recordId,
            int patientId,
            String diagnosis,
            String prescription,
            String medicalHistory,
            String recordDate) {

        this.recordId = recordId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.medicalHistory = medicalHistory;
        this.recordDate = recordDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getRecordDate() {
        return recordDate;
    }

    // Add record
    public void addRecord() {
        System.out.println("Medical record added successfully.");
    }

    // Update record
    public void updateRecord(
            String diagnosis,
            String prescription,
            String history,
            String date) {

        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.medicalHistory = history;
        this.recordDate = date;

        System.out.println("Medical record updated successfully.");
    }

    // View record
    public MedicalRecord viewRecord() {
        return this;
    }

    // Display record
    public void displayRecord() {

        System.out.println("\n---------- MEDICAL RECORD ----------");
        System.out.println("Record ID       : " + recordId);
        System.out.println("Patient ID      : " + patientId);
        System.out.println("Diagnosis       : " + diagnosis);
        System.out.println("Prescription    : " + prescription);
        System.out.println("Medical History : " + medicalHistory);
        System.out.println("Record Date     : " + recordDate);
        System.out.println("------------------------------------");
    }
}


// =====================================================
// ADMINISTRATOR CLASS
// =====================================================

class Administrator {

    private int adminId;
    private String username;
    private String password;

    public Administrator(
            int adminId,
            String username,
            String password) {

        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    // Login
    public boolean login(String username, String password) {

        return this.username.equals(username)
                && this.password.equals(password);
    }

    // Add doctor
    public void addDoctor(Doctor doctor) {
        System.out.println(
                "Doctor " + doctor.getName()
                + " added successfully.");
    }

    // Remove doctor
    public void removeDoctor(int doctorId) {
        System.out.println(
                "Doctor with ID " + doctorId
                + " removed successfully.");
    }

    // Manage patients
    public void managePatients() {
        System.out.println("Patient management selected.");
    }

    // Manage appointments
    public void manageAppointments() {
        System.out.println("Appointment management selected.");
    }

    // Hospital reports
    public void viewHospitalReports() {
        System.out.println("Hospital report option selected.");
    }
}


// =====================================================
// HOSPITAL CLASS
// =====================================================

class Hospital {

    private String hospitalName;

    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<MedicalRecord> medicalRecords;

    public Hospital(String hospitalName) {

        this.hospitalName = hospitalName;

        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        medicalRecords = new ArrayList<>();
                medicalRecords = new ArrayList<>();
    }


    // =================================================
    // GETTERS FOR HOSPITAL DATA
    // =================================================

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    // =================================================
    // PATIENT MANAGEMENT
    // =================================================

    public void addPatient(Patient patient) {

        patients.add(patient);

        System.out.println(
                "\nPatient registered successfully!");
        System.out.println(
                "Patient ID: " + patient.getPatientId());
    }

    public Patient findPatient(int patientId) {

        for (Patient p : patients) {

            if (p.getPatientId() == patientId) {
                return p;
            }
        }

        return null;
    }

    public void displayAllPatients() {

        if (patients.isEmpty()) {

            System.out.println("No patients registered.");
            return;
        }

        System.out.println("\n========== ALL PATIENTS ==========");

        for (Patient p : patients) {

            System.out.println(
                    "ID: " + p.getPatientId()
                    + " | Name: " + p.getName()
                    + " | Disease: " + p.getDisease());
        }

        System.out.println("==================================");
    }


    // =================================================
    // DOCTOR MANAGEMENT
    // =================================================

    public void addDoctor(Doctor doctor) {

        doctors.add(doctor);

        System.out.println(
                "\nDoctor added successfully!");
        System.out.println(
                "Doctor ID: " + doctor.getDoctorId());
    }

    public Doctor findDoctor(int doctorId) {

        for (Doctor d : doctors) {

            if (d.getDoctorId() == doctorId) {
                return d;
            }
        }

        return null;
    }

    public void removeDoctor(int doctorId) {

        Doctor doctor = findDoctor(doctorId);

        if (doctor != null) {

            doctors.remove(doctor);

            System.out.println(
                    "Doctor removed successfully.");

        } else {

            System.out.println(
                    "Doctor not found.");
        }
    }

    public void displayAllDoctors() {

        if (doctors.isEmpty()) {

            System.out.println("No doctors available.");
            return;
        }

        System.out.println("\n========== ALL DOCTORS ==========");

        for (Doctor d : doctors) {

            System.out.println(
                    "ID: " + d.getDoctorId()
                    + " | Name: " + d.getName()
                    + " | Specialization: "
                    + d.getSpecialization()
                    + " | Department: "
                    + d.getDepartment());
        }

        System.out.println("=================================");
    }


    // =================================================
    // APPOINTMENT MANAGEMENT
    // =================================================

    public boolean isDoctorAvailable(
            int doctorId,
            String date,
            String time) {

        for (Appointment a : appointments) {

            if (a.getDoctor().getDoctorId() == doctorId
                    && a.getDate().equalsIgnoreCase(date)
                    && a.getTime().equalsIgnoreCase(time)
                    && !a.getStatus().equalsIgnoreCase("Cancelled")) {

                return false;
            }
        }

        return true;
    }

    public void addAppointment(Appointment appointment) {

        appointments.add(appointment);
    }

    public Appointment findAppointment(int appointmentId) {

        for (Appointment a : appointments) {

            if (a.getAppointmentId() == appointmentId) {
                return a;
            }
        }

        return null;
    }

    public void displayPatientAppointments(int patientId) {

        boolean found = false;

        System.out.println("\n======= YOUR APPOINTMENTS =======");

        for (Appointment a : appointments) {

            if (a.getPatient().getPatientId() == patientId) {

                a.displayAppointment();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No appointments found.");
        }

        System.out.println(
                "================================");
    }

    public void displayDoctorAppointments(int doctorId) {

        boolean found = false;

        System.out.println("\n====== DOCTOR APPOINTMENTS ======");

        for (Appointment a : appointments) {

            if (a.getDoctor().getDoctorId() == doctorId) {

                a.displayAppointment();
                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No appointments found.");
        }

        System.out.println(
                "================================");
    }


    // =================================================
    // MEDICAL RECORD MANAGEMENT
    // =================================================

    public void addMedicalRecord(MedicalRecord record) {

        medicalRecords.add(record);

        System.out.println(
                "Medical record added successfully.");
    }

    public MedicalRecord findMedicalRecord(int patientId) {

        for (MedicalRecord r : medicalRecords) {

            if (r.getPatientId() == patientId) {

                return r;
            }
        }

        return null;
    }

    public void displayPatientRecord(int patientId) {

        MedicalRecord record =
                findMedicalRecord(patientId);

        if (record != null) {

            record.displayRecord();

        } else {

            System.out.println(
                    "No medical record found.");
        }
    }


    // =================================================
    // REPORTS
    // =================================================

    public void generateReport() {

        System.out.println("\n========== HOSPITAL REPORT ==========");

        System.out.println(
                "Hospital Name       : " + hospitalName);

        System.out.println(
                "Total Patients      : " + patients.size());

        System.out.println(
                "Total Doctors       : " + doctors.size());

        System.out.println(
                "Total Appointments  : "
                + appointments.size());

        System.out.println(
                "Medical Records     : "
                + medicalRecords.size());

        System.out.println(
                "======================================");
    }
}


// =====================================================
// MAIN CLASS
// =====================================================

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Hospital hospital =
            new Hospital("City Care Hospital");

    static Administrator administrator =
            new Administrator(
                    1,
                    "admin",
                    "admin123");

    static int nextPatientId = 1001;
    static int nextDoctorId = 501;
    static int nextAppointmentId = 10001;
    static int nextRecordId = 20001;


    // =================================================
    // MAIN METHOD
    // =================================================

    public static void main(String[] args) {

        addSampleDoctors();

        System.out.println(
                "\n==============================================");
        System.out.println(
                " HOSPITAL APPOINTMENT AND PATIENT");
        System.out.println(
                " MANAGEMENT SYSTEM");
        System.out.println(
                "==============================================");

        mainMenu();
    }


    // =================================================
    // SAMPLE DOCTORS
    // =================================================

    public static void addSampleDoctors() {

        Doctor d1 = new Doctor(
                nextDoctorId++,
                "Dr. Arun Kumar",
                "9876543210",
                "arun@hospital.com",
                "Cardiologist",
                "Cardiology",
                10);

        Doctor d2 = new Doctor(
                nextDoctorId++,
                "Dr. Meera Nair",
                "9876501234",
                "meera@hospital.com",
                "Dermatologist",
                "Dermatology",
                7);

        Doctor d3 = new Doctor(
                nextDoctorId++,
                "Dr. Rahul Menon",
                "9876512345",
                "rahul@hospital.com",
                "General Physician",
                "General Medicine",
                8);

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addDoctor(d3);
    }


    // =================================================
    // MAIN MENU
    // =================================================

    public static void mainMenu() {

        int choice;

        do {

            System.out.println(
                    "\n============== MAIN MENU ==============");

            System.out.println(
                    "1. Patient Registration");

            System.out.println(
                    "2. Patient Login");

            System.out.println(
                    "3. Doctor Login");

            System.out.println(
                    "4. Administrator Login");

            System.out.println(
                    "5. Exit");

            System.out.println(
                    "========================================");

            choice = readInt(
                    "Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    patientLogin();
                    break;

                case 3:
                    doctorLogin();
                    break;

                case 4:
                    administratorLogin();
                    break;

                case 5:
                    System.out.println(
                            "\nThank you for using the system!");
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Try again.");
            }

        } while (choice != 5);
    }


    // =================================================
    // PATIENT REGISTRATION
    // =================================================

    public static void registerPatient() {

        System.out.println(
                "\n========== PATIENT REGISTRATION ==========");

        String name =
                readString("Enter patient name: ");

        String phone =
                readString("Enter phone number: ");

        String email =
                readString("Enter email: ");

        String disease =
                readString("Enter disease/problem: ");

        String address =
                readString("Enter address: ");

        String bloodGroup =
                readString("Enter blood group: ");

        String emergencyContact =
                readString("Enter emergency contact: ");

        Patient patient =
                new Patient(
                        nextPatientId++,
                        name,
                        phone,
                        email,
                        disease,
                        address,
                        bloodGroup,
                        emergencyContact);

        hospital.addPatient(patient);

        patient.registerPatient();

        System.out.println(
                "\nPlease remember your Patient ID: "
                + patient.getPatientId());
    }


    // =================================================
    // PATIENT LOGIN
    // =================================================

    public static void patientLogin() {

        System.out.println(
                "\n============= PATIENT LOGIN =============");

        int patientId =
                readInt("Enter Patient ID: ");

        Patient patient =
                hospital.findPatient(patientId);

        if (patient == null) {

            System.out.println(
                    "Patient not found.");

            return;
        }

        System.out.println(
                "\nWelcome, " + patient.getName() + "!");

        patientMenu(patient);
    }


    // =================================================
    // PATIENT MENU
    // =================================================

    public static void patientMenu(Patient patient) {

        int choice;

        do {

            System.out.println(
                    "\n============= PATIENT MENU =============");

            System.out.println(
                    "1. View Patient Details");

            System.out.println(
                    "2. View Available Doctors");

            System.out.println(
                    "3. Book Appointment");

            System.out.println(
                    "4. Reschedule Appointment");

            System.out.println(
                    "5. Cancel Appointment");

            System.out.println(
                    "6. View My Appointments");

            System.out.println(
                    "7. View Medical Record");

            System.out.println(
                    "8. Logout");

            System.out.println(
                    "========================================");

            choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    patient.displayDetails();
                    break;

                case 2:
                    hospital.displayAllDoctors();
                    break;

                case 3:
                    bookAppointment(patient);
                    break;

                case 4:
                    rescheduleAppointment(patient);
                    break;

                case 5:
                    cancelAppointment(patient);
                    break;

                case 6:
                    hospital.displayPatientAppointments(
                            patient.getPatientId());
                    break;

                case 7:
                    patient.viewMedicalRecord();

                    hospital.displayPatientRecord(
                            patient.getPatientId());
                    break;

                case 8:
                    System.out.println(
                            "Logged out successfully.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 8);
    }


    // =================================================
    // BOOK APPOINTMENT
    // =================================================

    public static void bookAppointment(
            Patient patient) {

        System.out.println(
                "\n========== BOOK APPOINTMENT ==========");

        hospital.displayAllDoctors();

        int doctorId =
                readInt("Enter Doctor ID: ");

        Doctor doctor =
                hospital.findDoctor(doctorId);

        if (doctor == null) {

            System.out.println(
                    "Doctor not found.");

            return;
        }

        String date =
                readString("Enter appointment date (DD-MM-YYYY): ");

        String time =
                readString("Enter appointment time: ");

        // Check doctor availability
        if (!hospital.isDoctorAvailable(
                doctorId, date, time)) {

            System.out.println(
                    "\nDoctor is NOT available at this time.");

            return;
        }

        Appointment appointment =
                new Appointment(
                        nextAppointmentId++,
                        patient,
                        doctor,
                        date,
                        time);

        appointment.bookAppointment();

        hospital.addAppointment(appointment);

        patient.bookAppointment();

        System.out.println(
                "\nAppointment booked successfully!");

        appointment.displayAppointment();
    }


    // =================================================
    // RESCHEDULE APPOINTMENT
    // =================================================

    public static void rescheduleAppointment(
            Patient patient) {

        System.out.println(
                "\n======= RESCHEDULE APPOINTMENT =======");

        hospital.displayPatientAppointments(
                patient.getPatientId());

        int appointmentId =
                readInt("Enter Appointment ID: ");

        Appointment appointment =
                hospital.findAppointment(
                        appointmentId);

        if (appointment == null
                || appointment.getPatient()
                        .getPatientId()
                        != patient.getPatientId()) {

            System.out.println(
                    "Appointment not found.");

            return;
        }

        if (appointment.getStatus()
                .equalsIgnoreCase("Cancelled")) {

            System.out.println(
                    "Cancelled appointment cannot be rescheduled.");

            return;
        }

        String newDate =
                readString("Enter new date: ");

        String newTime =
                readString("Enter new time: ");

        if (!hospital.isDoctorAvailable(
                appointment.getDoctor().getDoctorId(),
                newDate,
                newTime)) {

            System.out.println(
                    "Doctor is not available at the new time.");

            return;
        }

        appointment.rescheduleAppointment(
                newDate,
                newTime);

        System.out.println(
                "\nAppointment rescheduled successfully!");

        appointment.displayAppointment();
    }


    // =================================================
    // CANCEL APPOINTMENT
    // =================================================

    public static void cancelAppointment(
            Patient patient) {

        System.out.println(
                "\n========= CANCEL APPOINTMENT =========");

        hospital.displayPatientAppointments(
                patient.getPatientId());

        int appointmentId =
                readInt("Enter Appointment ID: ");

        Appointment appointment =
                hospital.findAppointment(
                        appointmentId);

        if (appointment == null
                || appointment.getPatient()
                        .getPatientId()
                        != patient.getPatientId()) {

            System.out.println(
                    "Appointment not found.");

            return;
        }

        appointment.cancelAppointment();

        patient.cancelAppointment();

        System.out.println(
                "Appointment cancelled successfully.");
    }


    // =================================================
    // DOCTOR LOGIN
    // =================================================

    public static void doctorLogin() {

        System.out.println(
                "\n============== DOCTOR LOGIN ==============");

        int doctorId =
                readInt("Enter Doctor ID: ");

        Doctor doctor =
                hospital.findDoctor(doctorId);

        if (doctor == null) {

            System.out.println(
                    "Doctor not found.");

            return;
        }

        System.out.println(
                "\nWelcome Dr. " + doctor.getName());

        doctorMenu(doctor);
    }


    // =================================================
    // DOCTOR MENU
    // =================================================

    public static void doctorMenu(
            Doctor doctor) {

        int choice;

        do {

            System.out.println(
                    "\n============== DOCTOR MENU ==============");

            System.out.println(
                    "1. View Doctor Details");

            System.out.println(
                    "2. View Appointments");

            System.out.println(
                    "3. View Patient Information");

            System.out.println(
                    "4. Manage Medical Record");

            System.out.println(
                    "5. Logout");

            System.out.println(
                    "==========================================");

            choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    doctor.displayDetails();
                    break;

                case 2:
                    doctor.viewAppointments();

                    hospital.displayDoctorAppointments(
                            doctor.getDoctorId());
                    break;

                case 3:
                    int patientId =
                            readInt("Enter Patient ID: ");

                    Patient patient =
                            hospital.findPatient(patientId);

                    if (patient != null) {

                        doctor.viewPatientDetails(
                                patientId);

                        patient.displayDetails();

                    } else {

                        System.out.println(
                                "Patient not found.");
                    }

                    break;

                case 4:
                    manageMedicalRecord(doctor);
                    break;

                case 5:
                    System.out.println(
                            "Logged out successfully.");
                    break;

                default:
                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 5);
    }


    // =================================================
    // MANAGE MEDICAL RECORD
    // =================================================

    public static void manageMedicalRecord(
            Doctor doctor) {

        System.out.println(
                "\n======== MANAGE MEDICAL RECORD ========");

        int patientId =
                readInt("Enter Patient ID: ");

        Patient patient =
                hospital.findPatient(patientId);

        if (patient == null) {

            System.out.println(
                    "Patient not found.");

            return;
        }

        MedicalRecord record =
                hospital.findMedicalRecord(
                        patientId);

        System.out.println(
                "\n1. Add New Record");

        System.out.println(
                "2. Update Existing Record");

        int choice =
                readInt("Enter choice: ");

        String diagnosis =
                readString("Enter diagnosis: ");

        String prescription =
                readString("Enter prescription: ");

        String history =
                readString("Enter medical history: ");

        String date =
                readString("Enter record date: ");

        if (choice == 1) {

            if (record != null) {

                System.out.println(
                        "A medical record already exists for this patient.");

                return;
            }

            record =
                    new MedicalRecord(
                            nextRecordId++,
                            patientId,
                            diagnosis,
                            prescription,
                            history,
                            date);

            hospital.addMedicalRecord(record);

            doctor.updateMedicalRecord(
                    patientId,
                    record);

        } else if (choice == 2) {

            if (record == null) {

                System.out.println(
                        "No existing record found.");

                return;
            }

            record.updateRecord(
                    diagnosis,
                    prescription,
                    history,
                    date);

            doctor.updateMedicalRecord(
                    patientId,
                    record);

        } else {

            System.out.println(
                    "Invalid choice.");
        }
    }


    // =================================================
    // ADMINISTRATOR LOGIN
    // =================================================

    public static void administratorLogin() {

        System.out.println(
                "\n========= ADMINISTRATOR LOGIN =========");

        String username =
                readString("Username: ");

        String password =
                readString("Password: ");

        if (administrator.login(
                username,
                password)) {

            System.out.println(
                    "\nLogin successful!");

            administratorMenu();

        } else {

            System.out.println(
                    "\nInvalid username or password.");
        }
    }


    // =================================================
    // ADMINISTRATOR MENU
    // =================================================

    public static void administratorMenu() {

        int choice;

        do {

            System.out.println(
                    "\n========= ADMINISTRATOR MENU =========");

            System.out.println(
                    "1. View All Patients");

            System.out.println(
                    "2. View All Doctors");

            System.out.println(
                    "3. Add Doctor");

            System.out.println(
                    "4. Remove Doctor");

            System.out.println(
                    "5. View Hospital Appointments");

            System.out.println(
                    "6. Generate Hospital Report");

            System.out.println(
                    "7. Logout");

            System.out.println(
                    "======================================");

            choice =
                    readInt("Enter your choice: ");

            switch (choice) {

                case 1:

                    administrator.managePatients();

                    hospital.displayAllPatients();

                    break;

                case 2:

                    hospital.displayAllDoctors();

                    break;

                case 3:

                    addNewDoctor();

                    break;

                case 4:

                    int doctorId =
                            readInt("Enter Doctor ID to remove: ");

                    hospital.removeDoctor(
                            doctorId);

                    break;

                case 5:

                    administrator.manageAppointments();

                    System.out.println(
                            "Appointment management is available through "
                            + "patient and doctor menus.");

                    break;

                case 6:

                    administrator.viewHospitalReports();

                    hospital.generateReport();

                    break;

                case 7:

                    System.out.println(
                            "Logged out successfully.");

                    break;

                default:

                    System.out.println(
                            "Invalid choice.");
            }

        } while (choice != 7);
    }


    // =================================================
    // ADD NEW DOCTOR
    // =================================================

    public static void addNewDoctor() {

        System.out.println(
                "\n=========== ADD NEW DOCTOR ===========");

        String name =
                readString("Doctor name: ");

        String phone =
                readString("Phone: ");

        String email =
                readString("Email: ");

        String specialization =
                readString("Specialization: ");

        String department =
                readString("Department: ");

        int experience =
                readInt("Years of experience: ");

        Doctor doctor =
                new Doctor(
                        nextDoctorId++,
                        name,
                        phone,
                        email,
                        specialization,
                        department,
                        experience);

        hospital.addDoctor(doctor);

        administrator.addDoctor(doctor);
    }


    // =================================================
    // INPUT METHODS
    // =================================================

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine();

                return Integer.parseInt(
                        input.trim());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number.");
            }
        }
    }


    public static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }
}