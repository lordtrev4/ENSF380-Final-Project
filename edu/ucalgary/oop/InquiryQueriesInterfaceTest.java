package edu.ucalgary.oop;
import static org.junit.Assert.assertEquals;

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
        Inquirer inquirer = new Inquirer();
        inquirer.setTypeReliefWorker("central");

        // Assuming you have a getter for workerType
        assertEquals("central", inquirer.getWorkerType());

        inquirer.setTypeReliefWorker("location");
        assertEquals("location", inquirer.getWorkerType());
    }
}
