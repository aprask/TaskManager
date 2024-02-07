package com.taskmanager.springtaskmanager.Service;

import com.taskmanager.springtaskmanager.Model.User;
import com.taskmanager.springtaskmanager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.retrieveAllUsers();
    }
    public User getUserById(Long id) {
        if(id < 0 || id > userRepository.retrieveAllUsers().size()) throw new RuntimeException("Not an appropriate value");
        return userRepository.findUserByID(id);
    }
    public void saveUser(User user) {
        if(user == null) throw new NullPointerException("Cannot find user");
        userRepository.save(user);
    }
    public void updateUser(User user) {
        if(user == null) throw new NullPointerException("Cannot find user");
        userRepository.update(user);
    }
    public void deleteUser(Long id) {
        if(id < 0 || id > userRepository.retrieveAllUsers().size()) throw new RuntimeException("Not an appropriate value");
        else if(getUserById(id) == null) throw new NullPointerException("Cannot find user");
        userRepository.delete(id);
    }
}