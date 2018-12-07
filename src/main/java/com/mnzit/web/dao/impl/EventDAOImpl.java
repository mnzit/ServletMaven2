/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnzit.web.dao.impl;

import com.mnzit.jdbc.core.JdbcTemplate;
import com.mnzit.jdbc.core.RowMapper;
import com.mnzit.web.dao.EventDAO;
import com.mnzit.web.entity.Event;
import com.mnzit.web.util.LinkGenerator;
import java.net.InetAddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mnzit
 */
public class EventDAOImpl implements EventDAO {

    JdbcTemplate<Event> template = new JdbcTemplate<Event>();

    public List<Event> getAll() throws Exception {
        return template.query("SELECT * FROM event", new EventMapper());
    }

    public Event getByObject(String key, Object value) throws Exception {
        return template.queryByObject("SELECT * FROM event WHERE " + key + "=?", new Object[]{value}, new EventMapper());
    }

    public int insert(Event model) throws Exception {
        String sql = "INSERT INTO event("
                + "title,"
                + "description,"
                + "start_date,"
                + "end_date,"
                + "status,"
                + "link) VALUES(?,?,?,?,?,?)";
        return template.update(sql, new Object[]{
            model.getTitle(),
            model.getDescription(),
            model.getStartDate(),
            model.getEndDate(),
            model.isStatus(),
            LinkGenerator.toLink(model.getTitle())});
    }

    public int update(Event model) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Event> getAllByObject(String key, Object value) throws Exception {
         return template.queryAllByObject("SELECT * FROM event WHERE " + key + "=?", new Object[]{value}, new EventMapper());
    }

    public class EventMapper implements RowMapper<Event> {

        public Event mapRow(ResultSet rs) throws SQLException {
            Event event = new Event();
            event.setId(rs.getInt("id"));
            event.setTitle(rs.getString("title"));
            event.setDescription(rs.getString("description"));
            event.setStartDate(rs.getDate("start_date"));
            event.setEndDate(rs.getDate("end_date"));
            event.setStatus(rs.getBoolean("status"));
            event.setLink(rs.getString("link"));
            return event;
        }

    }

}
