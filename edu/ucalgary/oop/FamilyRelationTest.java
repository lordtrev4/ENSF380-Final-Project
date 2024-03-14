/*
Copyright Ann Barcomb and Khawla Shnaikat, 2024
Licensed under GPL v3
See LICENSE.txt for more information.
*/
package edu.ucalgary.oop;


import org.junit.Test;
import static org.junit.Assert.*;

public class FamilyRelationTest {

    private DisasterVictim personOne = new DisasterVictim("John Dalan", "2024-01-19");
    private DisasterVictim personTwo = new DisasterVictim("Jane Dalan", "2024-02-20");
    private String relationshipTo = "sibling";
    private FamilyRelation testFamilyRelationObject = new FamilyRelation(personOne, relationshipTo, personTwo);
    
    @Test
    public void testObjectCreation() {
        assertNotNull(testFamilyRelationObject);
    }
	
    @Test
    public void testSetAndGetPersonOne() {
        DisasterVictim newPersonOne = new DisasterVictim("Jason Lee", "2024-03-21");
        testFamilyRelationObject.setPersonOne(newPersonOne);
        assertEquals("setPersonOne should update personOne", newPersonOne, testFamilyRelationObject.getPersonOne());
    }

    @Test
    public void testSetAndGetPersonTwo() {
        DisasterVictim newPersonTwo = new DisasterVictim("Jared Lee", "2024-04-22");
        testFamilyRelationObject.setPersonTwo(newPersonTwo);
        assertEquals("setPersonTwo should update personTwo", newPersonTwo, testFamilyRelationObject.getPersonTwo());
    }

    @Test
    public void testSetAndGetRelationshipTo() {
        String newRelationship = "parent";
        testFamilyRelationObject.setRelationshipTo(newRelationship);
        assertEquals("setRelationshipTo should update the relationship", newRelationship, testFamilyRelationObject.getRelationshipTo());
    }
    
    @Test
    public void testTwoSidedRelationship() {
        DisasterVictim sam = new DisasterVictim("Sam");
        DisasterVictim peace = new DisasterVictim("Peace");

        sam.setRelationshipTo(peace);

        assertTrue(sam.getRelationships().contains(peace));
        assertTrue(peace.getRelationships().contains(sam));
    }

    @Test
    public void testNoDuplicateRelationships() {
        DisasterVictim sam = new DisasterVictim("Sam");
        DisasterVictim peace = new DisasterVictim("Peace");

        sam.addRelationshipTo(peace);
        sam.addRelationshipTo(peace);

        assertEquals(1, sam.getRelationships().size());
        assertEquals(1, peace.getRelationships().size());
    }
}
