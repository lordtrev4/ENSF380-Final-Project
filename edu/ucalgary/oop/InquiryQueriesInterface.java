package edu.ucalgary.oop;


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
        this.DisasterVictimName = DisasterVictimName;
        // Add code here to find the disaster victim by name
    }

    @Override
    public void setTypeReliefWorker(String workerType) {
        this.workerType = workerType;
        // Add code here to set the type of the relief worker
    }
}