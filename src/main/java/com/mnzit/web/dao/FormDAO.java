/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao;

import com.mnzit.web.entity.Form;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public interface FormDAO extends GenericDAO<Form>{
     List<Form> getAllByObject(String key, Object value) throws Exception;
}
