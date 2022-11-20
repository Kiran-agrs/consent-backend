package com.example.consent.src.model;


public class CTaskResponse {
    String name;
    String emailId;
    String cTask;

    boolean consentGiven;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getcTask() {
        return cTask;
    }

    public void setcTask(String cTask) {
        this.cTask = cTask;
    }

    public boolean isConsentGiven() {
        return consentGiven;
    }

    public void setConsentGiven(boolean consentGiven) {
        this.consentGiven = consentGiven;
    }

    public CTaskResponse() {

    }

    public CTaskResponse(String name, String emailId, String cTask, boolean isConsentGiven) {
        this.name = name;
        this.emailId = emailId;
        this.cTask = cTask;
        this.consentGiven = isConsentGiven;
    }
}
