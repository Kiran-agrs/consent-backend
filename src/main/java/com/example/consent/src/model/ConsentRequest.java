package com.example.consent.src.model;

public class ConsentRequest {
    String cTask;
    boolean consentGiven;

    public ConsentRequest(String cTask, boolean consentGiven) {
        this.cTask = cTask;
        this.consentGiven = consentGiven;
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
}
