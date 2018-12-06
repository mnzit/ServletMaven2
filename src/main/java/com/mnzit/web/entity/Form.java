/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.entity;

/**
 *
 * @author Mnzit
 */
public class Form extends Entity{
    private int eventId;
    private String firstName, lastName, emailId, contactNo;

    public Form() {
    }

    public Form(int eventId, String firstName, String lastName, String emailId, String contactNo) {
        this.eventId = eventId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.contactNo = contactNo;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

   

    
}
