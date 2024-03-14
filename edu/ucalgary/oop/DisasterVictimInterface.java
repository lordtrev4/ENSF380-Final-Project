package edu.ucalgary.oop;
import java.util.ArrayList;

public interface DisasterVictimInterface {
    void updateFirstName(String firstName);
    void updateLastName(String lastName);
    void updateDateOfBirth(String dateOfBirth);
    void updateGender(String gender);
    void updateComments(String comments);
    void updateMedicalRecords(ArrayList<MedicalRecord> medicalRecords);
    void updatePersonalBelongings(ArrayList<Supply> supplies);
    void updateFamilyConnections(ArrayList<FamilyRelation> relation);
}

public class DisasterVictim implements DisasterVictimInterface {
    // Assuming these attributes exist in the class
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String comments;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<Supply> supplies;
    private ArrayList<FamilyRelation> familyConnections;

    @Override
    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void updateLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void updateDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void updateGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void updateComments(String comments) {
        this.comments = comments;
    }

    @Override
    public void updateMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    @Override
    public void updatePersonalBelongings(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }

    @Override
    public void updateFamilyConnections(ArrayList<FamilyRelation> relation) {
        this.familyConnections = relation;
    }
}