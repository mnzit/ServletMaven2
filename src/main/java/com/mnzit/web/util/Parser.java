/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mnzit
 */
public class Parser {

    private Map<String, String> datas;

    private String leftDelim="{", rightDelim="}";

    public Parser() {
        this.datas = new HashMap<String,String>();
    }

    public Parser(Map<String, String> datas, String leftDelim, String rightDelim) {
        this.leftDelim = leftDelim;
        this.rightDelim = rightDelim; 
    }
    
    public Parser add(String key,String value){
        datas.put(key,value);
        return this;
    }
    
    public String parse(String content){
        String output = content;    
        for (Map.Entry<String, String> entry : datas.entrySet()) {
            output = output.replace(leftDelim + entry.getKey() +rightDelim,  entry.getValue());
        }
        return output;
    }

}
