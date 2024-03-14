package edu.ucalgary.oop;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumSet;

public class DisasterVictimInterfaceTest {
    private DisasterVictim victim;

    @Before
    public void setUp() {
        victim = new DisasterVictim("Jane", "2024-01-20");
    }

    @Test
    public void testUpdateFirstName() {
        String firstName = "John";
        victim.updateFirstName(firstName);
        assertEquals(firstName, victim.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        String lastName = "Doe";
        victim.updateLastName(lastName);
        assertEquals(lastName, victim.getLastName());
    }

    @Test
    public void testUpdateDateOfBirth() {
        String dateOfBirth = "01-01-2000";
        victim.updateDateOfBirth(dateOfBirth);
        assertEquals(dateOfBirth, victim.getDateOfBirth());
    }

    @Test
    public void testUpdateGender() {
        String gender = "Male";
        victim.updateGender(gender);
        assertEquals(gender, victim.getGender());
    }

    @Test
    public void testUpdateComments() {
        String comments = "Some comments";
        victim.updateComments(comments);
        assertEquals(comments, victim.getComments());
    }

    @Test
    public void testUpdateMedicalRecords() {
        ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
        victim.updateMedicalRecords(medicalRecords);
        assertEquals(medicalRecords, victim.getMedicalRecords());
    }

    @Test
    public void testUpdatePersonalBelongings() {
        ArrayList<Supply> supplies = new ArrayList<>();
        victim.updatePersonalBelongings(supplies);
        assertEquals(supplies, victim.getPersonalBelongings());
    }

    @Test
    public void testUpdateFamilyConnections() {
        ArrayList<FamilyRelation> familyConnections = new ArrayList<>();
        victim.updateFamilyConnections(familyConnections);
        assertEquals(familyConnections, victim.getFamilyConnections());
    }
}
