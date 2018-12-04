/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.entity;

import java.sql.Date;

/**
 *
 * @author Mnzit
 */
public class User extends Entity{
    private String userName,password,email;
    private boolean status;

    public User() {
    }

    public User(int id, String userName, String password, String email, boolean status, Date addedDate, Date modifiedDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.status = status;
        this.addedDate = addedDate;
        this.modifiedDate = modifiedDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
