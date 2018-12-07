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

    T getByObject(String key, Object value) throws Exception;

    int insert(T model) throws Exception;

    int update(T model) throws Exception;

    int delete(int id) throws Exception;
    
    List<T> getAllByObject(String key, Object value) throws Exception;
}
