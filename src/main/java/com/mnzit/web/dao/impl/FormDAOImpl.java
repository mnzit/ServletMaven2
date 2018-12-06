/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.jdbc.core.JdbcTemplate;
import com.mnzit.jdbc.core.RowMapper;
import com.mnzit.web.dao.FormDAO;
import com.mnzit.web.entity.Form;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class FormDAOImpl implements FormDAO {

    JdbcTemplate<Form> template = new JdbcTemplate<Form>();

    public List<Form> getAll() throws Exception {
        return template.query("SELECT * FROM form", new FormMapper());
    }

    public Form getByObject(String key, Object value) throws Exception {
        return template.queryByObject("SELECT * FROM form WHERE " + key + "=?", new Object[]{value}, new FormMapper());
    }

    public int insert(Form model) throws Exception {
        String sql = "INSERT INTO form(first_name,last_name,email_id,contact_no,event_id) VALUES(?,?,?,?,?)";
        return template.update(sql, new Object[]{model.getFirstName(), model.getLastName(), model.getEmailId(), model.getContactNo(),model.getEventId()});
    }

    public int update(Form model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Form> getAllByObject(String key, Object value) throws Exception {
        return template.queryAllByObject("SELECT * FROM form WHERE " + key + "=?", new Object[]{value}, new FormMapper());
    }



    class FormMapper implements RowMapper<Form> {

        public Form mapRow(ResultSet rs) throws SQLException {
            Form form = new Form();
            form.setId(rs.getInt("id"));
            form.setFirstName(rs.getString("first_name"));
            form.setLastName(rs.getString("last_name"));
            form.setEmailId(rs.getString("email_id"));
            form.setContactNo(rs.getString("contact_no"));
            return form;
        }

    }

}
