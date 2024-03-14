package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class InquiryLogTest {

    @Test
    public void testInquirerLogConstructor() {
        Inquirer inquirer = new Inquirer("Jane", "Doe", "+1-123-456-7890", "looking for my husband");
        ArrayList<DisasterVictim> lookingFor = new ArrayList<>();
        lookingFor.add(new DisasterVictim("John Doe", "2024-01-01"));

        InquiryLog log = new InquiryLog(inquirer, lookingFor);

        assertEquals(inquirer, log.getInquirerInfo());
        assertEquals(lookingFor, log.getLookingFor());
    }

    @Test
    public void testSetandGetLookingFor() {
        Inquirer inquirer = new Inquirer("Jane", "Doe", "+1-123-456-7890", "looking for my husband");
        ArrayList<DisasterVictim> lookingFor = new ArrayList<>();
        lookingFor.add(new DisasterVictim("John Doe", "2024-01-01"));

        InquiryLog log = new InquiryLog(inquirer, lookingFor);

        log.setLookingFor(lookingFor);

        assertEquals("lookingFor should update to the set lookingFor", lookingFor, log.getLookingFor());
    }

    @Test
    public void testSetandGetInquirerInfo() {
        InquiryLog log = new InquiryLog(new Inquirer("Jason", "Doe", "123-456-7890", "Looking for my brother"), new ArrayList<>());

        Inquirer inquirer = new Inquirer("John", "Doe", "123-456-7890", "Looking for my wife");
    
        log.setInquirerInfo(inquirer);
    
        assertEquals("Inquirer should be updated with the inquirer info", inquirer, log.getInquirerInfo());
    }
}
