package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;

public interface InquiryQueriesInterface {
    void findDisasterVictimName(String DisasterVictimName);
    void setTypeReliefWorker(String workerType);
}

public class Inquirer implements InquiryQueriesInterface {
    // Assuming these attributes exist in the class
    private String DisasterVictimName;
    private String workerType;

    @Override
    public void findDisasterVictimName(String DisasterVictimName) {
        this.DisasterVictimName = DisasterVictimName.toLowerCase();
        // Add code here to find the disaster victim by name
    }

    public List<DisasterVictim> searchByName(String name) {
        List<DisasterVictim> matchingVictims = new ArrayList<>();
        String lowerCaseName = name.toLowerCase();

        for (DisasterVictim victim : allVictims) { // Assuming allVictims is a list of all victims
            if (victim.getFirstName().toLowerCase().contains(lowerCaseName) || victim.getLastName().toLowerCase().contains(lowerCaseName)) {
                matchingVictims.add(victim);
            }
        }

        return matchingVictims;
    }

    @Override
    public void setTypeReliefWorker(String workerType) {
        this.workerType = workerType;
        // Add code here to set the type of the relief worker
    }
}