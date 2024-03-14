package edu.ucalgary.oop;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.List;

import org.junit.Test;

public class InquiryQueriesInterfaceTest {
    @Test
    public void testFindDisasterVictimName() {
        Inquirer inquirer = new Inquirer();
        inquirer.findDisasterVictimName("Sam");

        // Assuming you have a getter for DisasterVictimName
        assertEquals("sam", inquirer.getDisasterVictimName());
        }
    
    @Test
    public void testSearchByName() {
        Inquirer inquirer = new Inquirer();

        // Assuming you have a method to add victims to allVictims
        inquirer.addVictim(new DisasterVictim("Sam", "Smith"));
        inquirer.addVictim(new DisasterVictim("John", "Doe"));

        List<DisasterVictim> victims = inquirer.searchByName("Sam");

        assertEquals(1, victims.size());
        assertEquals("Sam", victims.get(0).getFirstName());
    }

        @Test
    public void testSetTypeReliefWorker() {
        InquiryQueriesInterface worker = new InquiryQueriesInterface();

        // Test setting the worker type to "central"
        worker.setTypeReliefWorker("central");
        assertEquals("central", worker.getWorkerType());

        // Test setting the worker type to "location"
        worker.setTypeReliefWorker("location");
        assertEquals("location", worker.getWorkerType());

        // Test setting the worker type to an invalid value
        assertThrows(IllegalArgumentException.class, () -> {
            worker.setTypeReliefWorker("invalid");
        });
    }
}
