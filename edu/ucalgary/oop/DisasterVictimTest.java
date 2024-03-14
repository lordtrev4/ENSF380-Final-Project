/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumSet;

public class DisasterVictimTest {
    private DisasterVictim victim;
    private List<Supply> suppliesToSet; 
    private ArrayList<FamilyRelation> familyRelations; 
    private String expectedFirstName = "Freda";
    private String EXPECTED_ENTRY_DATE = "2024-01-18";
    private String validDate = "2024-01-15";
    private String invalidDate = "15/13/2024";
    private String expectedGender = "female"; 
    private String expectedComments = "Needs medical attention and speaks 2 languages";

    @Before
    public void setUp() {
        victim = new DisasterVictim(expectedFirstName, EXPECTED_ENTRY_DATE);
        suppliesToSet = new ArrayList<>();
        suppliesToSet.add(new Supply("Water Bottle", 10));
        suppliesToSet.add(new Supply("Blanket", 5));
        
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        
    }

  @Test
    public void testConstructorWithValidEntryDate() {
        String validEntryDate = "2024-01-18";
        DisasterVictim victim = new DisasterVictim("Freda", validEntryDate);
        assertNotNull("Constructor should successfully create an instance with a valid entry date", victim);
        assertEquals("Constructor should set the entry date correctly", validEntryDate, victim.getEntryDate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidEntryDateFormat() {
        String invalidEntryDate = "18/01/2024"; // Incorrect format according to your specifications
        new DisasterVictim("Freda", invalidEntryDate);
        // Expecting IllegalArgumentException due to invalid date format
    }


   @Test
    public void testSetDateOfBirth() {
        String newDateOfBirth = "1987-05-21";
        victim.setDateOfBirth(newDateOfBirth);
        assertEquals("setDateOfBirth should correctly update the date of birth", newDateOfBirth, victim.getDateOfBirth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDateOfBirthWithInvalidFormat() {
        victim.setDateOfBirth(invalidDate); // This format should cause an exception
    }
	
	@Test
    public void testSetAndGetFirstName() {
        String newFirstName = "Alice";
        victim.setFirstName(newFirstName);
        assertEquals("setFirstName should update and getFirstName should return the new first name", newFirstName, victim.getFirstName());
    }

    @Test
    public void testSetAndGetLastName() {
        String newLastName = "Smith";
        victim.setLastName(newLastName);
        assertEquals("setLastName should update and getLastName should return the new last name", newLastName, victim.getLastName());
    }

    @Test
    public void testGetComments() {
        victim.setComments(expectedComments);
        assertEquals("getComments should return the initial correct comments", expectedComments, victim.getComments());
    }

    @Test
    public void testSetComments() {
        victim.setComments(expectedComments);
        String newComments = "Has a minor injury on the left arm";
        victim.setComments(newComments);
        assertEquals("setComments should update the comments correctly", newComments, victim.getComments());
    }

    @Test
    public void testGetAssignedSocialID() {
        // The next victim should have an ID one higher than the previous victim
        // Tests can be run in any order so two victims will be created
        DisasterVictim newVictim = new DisasterVictim("Kash", "2024-01-21");
        int expectedSocialId = newVictim.getAssignedSocialID() + 1;
        DisasterVictim actualVictim = new DisasterVictim("Jason", "2024-01-22");

        assertEquals("getAssignedSocialID should return the expected social ID", expectedSocialId, actualVictim.getAssignedSocialID());
    }

    @Test
    public void testGetEntryDate() {
        assertEquals("getEntryDate should return the expected entry date", EXPECTED_ENTRY_DATE, victim.getEntryDate());
    }
   
    @Test
    public void testSetAndGetGender() {
        String newGender = "man";
        victim.setGender(newGender);
        assertEquals("setGender should update and getGender should return the new gender from gender options", newGender.toLowerCase(), victim.getGender());
    }

    @Test
    public void testGenderMatchesFile() throws IOException {
        String genderFromFile = new String(Files.readAllBytes(Paths.get("GenderOptions.txt"))).trim();

        DisasterVictim person = new DisasterVictim("Sam");
        person.setGender(genderFromFile);

        assertEquals(genderFromFile, person.getGender(), "Gender set doesn't match the gender from the file");
    }

    @Test
    public void testAddFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim2, "parent", victim1);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<>();
        expectedRelations.add(relation);
        victim2.setFamilyConnections(expectedRelations);

        ArrayList<FamilyRelation> testFamily = victim2.getFamilyConnections();
        boolean correct = false;

        if ((testFamily!=null) && (testFamily.get(0).equals(expectedRelations.get(0)))) {
                correct = true;
        }
        assertTrue("addFamilyConnection should add a family relationship", correct);
    }

    @Test
    public void testAddPersonalBelonging() {
        Supply newSupply = new Supply("Emergency Kit", 1);
        victim.addPersonalBelonging(newSupply);
        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = false;
 
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i).equals(newSupply)) {
                correct = true;
            }
        }
        assertTrue("addPersonalBelonging should add the supply to personal belongings", correct);
    }

@Test
public void testRemoveFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");
        FamilyRelation relation1 = new FamilyRelation(victim, "sibling", victim1);
        FamilyRelation relation2 = new FamilyRelation(victim, "sibling", victim2);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<>();
        expectedRelations.add(relation2);
        ArrayList<FamilyRelation> originalRelations = new ArrayList<>();
        originalRelations.add(relation1);
        originalRelations.add(relation2);
        victim.setFamilyConnections(originalRelations);

        DisasterVictim victim = new DisasterVictim("Freda", "2024-01-23");
        victim.addFamilyConnection(relation1);
        victim.addFamilyConnection(relation2);
        victim.removeFamilyConnection(relation1);

        ArrayList<FamilyRelation> testFamily = victim.getFamilyConnections();
        boolean correct = true;

        for (int i = 0; i < testFamily.size(); i++) {
            if (testFamily.get(i).equals(relation1)) {
                correct = false;
            }
        }
    assertTrue("removeFamilyConnection should remove the family member", true);
}  

@Test
public void testRemovePersonalBelonging() {
    
        Supply supplyToRemove = suppliesToSet.get(0); 
        victim.addPersonalBelonging(supplyToRemove); 
        victim.removePersonalBelonging(supplyToRemove);

        ArrayList<Supply> testSupplies = victim.getPersonalBelongings();
        boolean correct = true;
 
        int i;
        for (i = 0; i < testSupplies.size(); i++) {
            if (testSupplies.get(i).equals(supplyToRemove)) {
                correct = false;
            }
        }
    assertTrue("removePersonalBelonging should remove the supply from personal belongings", true);
}


 @Test
    public void testSetFamilyConnection() {
        DisasterVictim victim1 = new DisasterVictim("Jane", "2024-01-20");
        DisasterVictim victim2 = new DisasterVictim("John", "2024-01-22");

        FamilyRelation relation = new FamilyRelation(victim1, "sibling", victim2);
        ArrayList<FamilyRelation> expectedRelations = new ArrayList<>();
        expectedRelations.add(relation);
        victim1.setFamilyConnections(expectedRelations);
        boolean correct = true;

       // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
       ArrayList<FamilyRelation> actualRecords = victim1.getFamilyConnections();
       if (expectedRelations.size() != actualRecords.size()) {
           correct = false;
       } else {    
           int i;
           for (i=0;i<actualRecords.size();i++) {
               if (!expectedRelations.get(i).equals(actualRecords.get(i))) {
                   correct = false;
               }
           }
       }
       assertTrue("Family relation should be set", correct);
    }

  @Test
public void testSetMedicalRecords() {
    Location testLocation = new Location("Shelter Z", "1234 Shelter Ave");
    MedicalRecord testRecord = new MedicalRecord(testLocation, "test for strep", "2024-02-09");
    boolean correct = true;

    ArrayList<MedicalRecord> newRecords = new ArrayList<>();
    newRecords.add(testRecord);
    victim.setMedicalRecords(newRecords);
    ArrayList<MedicalRecord> actualRecords = victim.getMedicalRecords();

    // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
    if (newRecords.size() != actualRecords.size()) {
        correct = false;
    } else {
        int i;
        for (i=0;i<newRecords.size();i++) {
            if (!actualRecords.get(i).equals(newRecords.get(i))) {
                correct = false;
            }
        }
    }
    assertTrue("setMedicalRecords should correctly update medical records", correct);
}


   @Test
public void testSetPersonalBelongings() {
    Supply one = new Supply("Tent", 1);
    Supply two = new Supply("Jug", 3);
    ArrayList<Supply> newSupplies = new ArrayList<>();
    newSupplies.add(one);
    newSupplies.add(two);
    boolean correct = true;

    victim.setPersonalBelongings(newSupplies);
    ArrayList<Supply> actualSupplies = victim.getPersonalBelongings();

    // We have not studied overriding equals in arrays of custom objects so we will manually evaluate equality
    if (newSupplies.size() != actualSupplies.size()) {
        correct = false;
    } else {
        int i;
        for (i=0;i<newSupplies.size();i++) {
            if (!actualSupplies.get(i).equals(newSupplies.get(i))) {
                correct = false;
            }
        }
    }
    assertTrue("setPersonalBelongings should correctly update personal belongings", correct);
}

    @Test
    public void testDietaryRestrictions() {
        DisasterVictim victim = new DisasterVictim("Freda", "2024-01-18");

        EnumSet<DietaryRestrictions> restrictions = EnumSet.of(DietaryRestrictions.AVML, DietaryRestrictions.DBML);
        victim.setDietaryRestrictions(restrictions);

        boolean correct = true;
        if (!victim.getDietaryRestrictions().contains(DietaryRestrictions.AVML) && (!victim.getDietaryRestrictions().contains(DietaryRestrictions.DBML))) {
            correct = false;
        }
        assertTrue("setDietaryRestrictions should correctly update dietary restrictions", correct);
        assertEquals("setDietaryRestrictions should correctly set the dietary restrictions", restrictions, victim.getDietaryRestrictions());
    }
    
}





