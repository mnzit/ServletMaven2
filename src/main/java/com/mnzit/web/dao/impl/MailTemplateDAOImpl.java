/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.jdbc.core.JdbcTemplate;
import com.mnzit.jdbc.core.RowMapper;
import com.mnzit.web.dao.MailTemplateDAO;
import com.mnzit.web.entity.MailTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class MailTemplateDAOImpl implements MailTemplateDAO {

    private JdbcTemplate<MailTemplate> template = new JdbcTemplate<MailTemplate>();

    public List<MailTemplate> getAll() throws Exception {
         return template.query("SELECT * FROM mail_template",  new RowMapper<MailTemplate>() {
            public MailTemplate mapRow(ResultSet rs) throws SQLException {
                MailTemplate mailTemplate = new MailTemplate();
                mailTemplate.setId(rs.getInt("id"));
                mailTemplate.setName(rs.getString("name"));
                mailTemplate.setDescription(rs.getString("description"));
                mailTemplate.setStatus(rs.getBoolean("status"));
                return mailTemplate;
            }
        });
    }

    public MailTemplate getByObject(String key,Object value) throws Exception {
        return template.queryByObject("SELECT * FROM mail_template where "+key+"=?", new Object[]{value}, new RowMapper<MailTemplate>() {
            public MailTemplate mapRow(ResultSet rs) throws SQLException {
                MailTemplate mailTemplate = new MailTemplate();
                mailTemplate.setId(rs.getInt("id"));
                mailTemplate.setName(rs.getString("name"));
                mailTemplate.setDescription(rs.getString("description"));
                mailTemplate.setStatus(rs.getBoolean("status"));
                return mailTemplate;
            }
        });
    }

    public int insert(MailTemplate model) throws Exception {
      String sql = "INSERT INTO mail_template(name,description,status) VALUES(?,?,?)";
      return template.update(sql,new Object[]{
                                              model.getName(),
                                              model.getDescription(),
                                              model.isStatus()
                                            });
    }

    public int delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int update(MailTemplate model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
