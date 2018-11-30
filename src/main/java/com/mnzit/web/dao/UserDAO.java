/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao;

import com.mnzit.web.entity.User;

/**
 *
 * @author Mnzit
 */
public interface UserDAO extends GenericDAO<User> {

    User login(String userName, String password) throws Exception;

    boolean isEmailExists(String email) throws Exception;
}
