package com.taskmanager.springtaskmanager.Repository;

import com.taskmanager.springtaskmanager.Model.Task;
import org.hibernate.annotations.processing.SQL;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class TaskRepositoryImpl implements TaskRepository {
    private final JdbcTemplate jdbcTemplate;
    public TaskRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Task findTaskByID(Long id) {
        String SQLCommand = "SELECT * FROM users WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(SQLCommand, new Object[]{id}, new BeanPropertyRowMapper<>(Task.class));
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Task> retrieveAllTasks() {
        return null;
    }

    @Override
    public void save(Task task) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Long id) {

    }
}
