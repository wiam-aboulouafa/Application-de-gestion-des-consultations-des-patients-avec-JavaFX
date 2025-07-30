package net.wiam.applicationgestionconsultationspatientsjavafx;

import java.time.LocalDate;

public class Consultation {
    private int id;
    private LocalDate date;
    private String diagnostic;
    private Patient patient;

    public Consultation(int id, LocalDate date, String diagnostic, Patient patient) {
        this.id = id;
        this.date = date;
        this.diagnostic = diagnostic;
        this.patient = patient;
    }

    public int getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getDiagnostic() { return diagnostic; }
    public Patient getPatient() { return patient; }

    public void setDate(LocalDate date) { this.date = date; }
    public void setDiagnostic(String diagnostic) { this.diagnostic = diagnostic; }
    public void setPatient(Patient patient) { this.patient = patient; }
}
