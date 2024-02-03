package com.taskmanager.springtaskmanager.Repository;

import com.taskmanager.springtaskmanager.Model.Task;
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
        String sqlCommand = "SELECT * FROM tasks WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(sqlCommand, new Object[]{id}, new BeanPropertyRowMapper<>(Task.class));
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Task> retrieveAllTasks() {
        String sqlCommand = "SELECT * FROM tasks";
        try{
            return (ArrayList<Task>) jdbcTemplate.query(sqlCommand, new BeanPropertyRowMapper<>(Task.class));
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Task task) {
        String sqlCommand = "INSERT INTO tasks (id, title, description, due_date, status) " +
                "+ VALUES (?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(
                    sqlCommand,
                    task.getTitle(),
                    task.getDescription(),
                    task.getDueDate(),
                    task.isComplete()
            );
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        jdbcTemplate.execute(sqlCommand);
    }

    @Override
    public void update(Task task) {
        String sqlCommand = "UPDATE tasks SET title = ?, description = ?, due_date = ?, status = ? WHERE id = ?";
        try{
            jdbcTemplate.update(
                    sqlCommand,
                    task.getTitle(),
                    task.getDescription(),
                    task.getDueDate(),
                    task.isComplete(),
                    task.getId()
            );
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE FROM tasks WHERE id = ?";
        try{
            jdbcTemplate.update(
                    sqlCommand,
                    id
            );
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
