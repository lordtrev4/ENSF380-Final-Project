package edu.ucalgary.oop;
import java.util.ArrayList;

public class InquiryLog {
    private ArrayList<DisasterVictim> lookingFor;
    private Inquirer inquirerInfo;

    public InquiryLog(Inquirer inquirerInfo, ArrayList<DisasterVictim> lookingFor) {
        this.inquirerInfo = inquirerInfo;
        this.lookingFor = lookingFor;
    }

    public ArrayList<DisasterVictim> getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(ArrayList<DisasterVictim> lookingFor) {
        this.lookingFor = lookingFor;
    }

    public Inquirer getInquirerInfo() {
        return inquirerInfo;
    }

    public void setInquirerInfo(Inquirer inquirerInfo) {
        this.inquirerInfo = inquirerInfo;
    }
}
