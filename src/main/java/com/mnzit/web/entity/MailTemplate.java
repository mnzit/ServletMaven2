/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.entity;

import java.util.Date;

/**
 *
 * @author Mnzit
 */
public class MailTemplate extends Entity {

    private String name, description;
    private boolean status;

    public MailTemplate() {
    }

    public MailTemplate(String name, String description, boolean status, Date addedDate, Date modifiedDate, int id) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    

}
