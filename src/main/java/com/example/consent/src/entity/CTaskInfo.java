package com.example.consent.src.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ctaskaccounts")
public class CTaskInfo {
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Id
    @Column(name = "cTask")
    String cTask;
    @Column(name = "consentGiven")
    boolean consentGiven;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
