package com.taskmanager.springtaskmanager.Controller;

import com.taskmanager.springtaskmanager.Model.User;
import com.taskmanager.springtaskmanager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public UserService getUserService() {
        return userService;
    }
}
