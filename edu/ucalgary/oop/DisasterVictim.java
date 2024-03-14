package edu.ucalgary.oop;

import java.util.List;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.ArrayList;
import java.time.LocalDate;


public class DisasterVictim {
    private static int counter = 0;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private ArrayList<FamilyRelation> familyConnections = new ArrayList<>();
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
    private ArrayList<Supply> personalBelongings;
    private EnumSet<DietaryRestrictions> dietaryRestrictions;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        if (!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format for entry date. Expected format: YYYY-MM-DD");
        }
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = generateSocialID();
        this.dietaryRestrictions = EnumSet.noneOf(DietaryRestrictions.class);
        
    }

    private static int generateSocialID() {
        counter++;
        return counter;
    }

    private static boolean isValidDateFormat(String date) {
        String dateFormatPattern = "^\\d{4}-\\d{2}-\\d{2}$";
        return date.matches(dateFormatPattern);
    }

  
    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isValidDateFormat(dateOfBirth)) {
            throw new IllegalArgumentException("Invalid date format for date of birth. Expected format: YYYY-MM-DD");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

  public ArrayList<FamilyRelation> getFamilyConnections() {
        return familyConnections;
    }

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public ArrayList<Supply> getPersonalBelongings() {
        return this.personalBelongings;
    }

    // The add and remove methods remain correct.
    
    // Correct the setters to accept Lists instead of arrays
    public void setFamilyConnections(ArrayList<FamilyRelation> connections) {
        this.familyConnections.clear();
        for (FamilyRelation newRecord : connections) {
            addFamilyConnection(newRecord);
        }
    }

    public void setMedicalRecords(ArrayList<MedicalRecord> records) {
        this.medicalRecords.clear();
        for (MedicalRecord newRecord : records) {
            addMedicalRecord(newRecord);
        }
    }

    public void setPersonalBelongings(ArrayList<Supply> belongings) {
        this.personalBelongings = belongings;
    }

    // Add a Supply to personalBelonging
    public void addPersonalBelonging(Supply supply) {
        if (this.personalBelongings == null) {
            this.personalBelongings = new ArrayList<>();
        }
        this.personalBelongings.add(supply);
    }
        // if (this.personalBelongings == null) {
        //     Supply tmpSupply[] = { supply };
        //     this.setPersonalBelongings(tmpSupply);
        //     return;
        // }

        // // Create an array one larger than the previous array
        // int newLength = this.personalBelongings.length + 1;
        // Supply tmpPersonalBelongings[] = new Supply[newLength];

        // // Copy all the items in the current array to the new array
        // int i;
        // for (i=0; i < personalBelongings.length; i++) {
        //     tmpPersonalBelongings[i] = this.personalBelongings[i];
        // }

        // // Add the new element at the end of the new array
        // tmpPersonalBelongings[i] = supply;

        // // Replace the original array with the new array
        // this.personalBelongings = tmpPersonalBelongings;
    // }

    // Remove a Supply from personalBelongings, we assume it only appears once
    public void removePersonalBelonging(Supply unwantedSupply) {
        ArrayList<Supply> updatedBelongings = new ArrayList<>();
        for (Supply supply : personalBelongings) {
            if (!supply.equals(unwantedSupply)) {
                updatedBelongings.add(supply);
            }
        }
        this.personalBelongings = updatedBelongings;
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        familyConnections.remove(exRelation);
    }

    public void addFamilyConnection(FamilyRelation record) {
        familyConnections.add(record);
    }


    // Add a MedicalRecord to medicalRecords
    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments =  comments;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.matches("(?i)^(man|woman|boy|gender queer|girl|non-binary|two-spirit)$")) {
            throw new IllegalArgumentException("Invalid gender. Acceptable values are: boy, gender queer, girl, man, non-binary, two-spirit or woman.");
        }
        this.gender = gender.toLowerCase(); // Store in a consistent format
    }

    public EnumSet<DietaryRestrictions> getDietaryRestrictions() {
        return this.dietaryRestrictions;
    }

    public void setDietaryRestrictions(EnumSet<DietaryRestrictions> restrictions) {
        this.dietaryRestrictions.clear();
        for (DietaryRestrictions restriction : restrictions) {
            this.dietaryRestrictions.add(restriction);
        }
    }
   
}





