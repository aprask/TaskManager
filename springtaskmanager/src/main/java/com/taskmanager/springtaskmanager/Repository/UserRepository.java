package com.taskmanager.springtaskmanager.Repository;

import com.taskmanager.springtaskmanager.Model.User;

import java.util.ArrayList;

public interface UserRepository {
    User findUserByID(Long id);
    ArrayList<User> retrieveAllUsers();
    void save(User user);
    void update(User user);
    void delete(Long id);
}
