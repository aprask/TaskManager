package com.taskmanager.springtaskmanager.Repository;

import com.taskmanager.springtaskmanager.Model.Task;

import java.util.ArrayList;

public interface TaskRepository {
    Task findTaskByID(Long id);
    ArrayList<Task> retrieveAllTasks();
    void save(Task task);

    void update(Task task);

    void delete(Long id);
}
