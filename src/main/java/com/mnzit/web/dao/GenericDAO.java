/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao;

import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface GenericDAO<T> {

    List<T> getAll() throws Exception;

    T getById(int id) throws Exception;
}
