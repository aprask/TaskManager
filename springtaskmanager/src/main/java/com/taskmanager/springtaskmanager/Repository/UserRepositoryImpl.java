package com.taskmanager.springtaskmanager.Repository;

import com.taskmanager.springtaskmanager.Model.Task;
import com.taskmanager.springtaskmanager.Model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findUserByID(Long id) {
        String sqlCommand = "SELECT * FROM users WHERE id = ?";
        try{
            return jdbcTemplate.queryForObject(sqlCommand, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<User> retrieveAllUsers() {
        String sqlCommand = "SELECT * FROM users";
        try{
            return (ArrayList<User>) jdbcTemplate.query(sqlCommand, new BeanPropertyRowMapper<>(User.class));
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sqlCommand = "INSERT INTO users (id, username, password) " +
                "+ VALUES (?, ?, ?)";
        try{
            jdbcTemplate.update(
                    sqlCommand,
                    user.getId(),
                    user.getUsername(),
                    user.getPassword()
            );
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
        jdbcTemplate.execute(sqlCommand);
    }

    @Override
    public void update(User user) {
        String sqlCommand = "UPDATE users SET id = ?, username = ?, password = ?";
        try{
            jdbcTemplate.update(
                    sqlCommand,
                    user.getId(),
                    user.getUsername(),
                    user.getPassword()
            );
        } catch (DataAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String sqlCommand = "DELETE FROM users WHERE id = ?";
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
