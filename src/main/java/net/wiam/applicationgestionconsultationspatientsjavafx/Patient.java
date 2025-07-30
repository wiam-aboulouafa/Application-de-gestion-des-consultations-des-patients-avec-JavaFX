package net.wiam.applicationgestionconsultationspatientsjavafx;

public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private int age;

    public Patient(int id, String nom, String prenom, int age) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}
