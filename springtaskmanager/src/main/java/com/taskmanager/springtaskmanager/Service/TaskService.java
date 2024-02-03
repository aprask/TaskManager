package com.taskmanager.springtaskmanager.Service;

import com.taskmanager.springtaskmanager.Model.Task;
import com.taskmanager.springtaskmanager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.retrieveAllTasks();
    }

    public Task getTaskById(Long id) {
        if (id < 0) throw new RuntimeException("Not an appropriate value");
        return taskRepository.findTaskByID(id);
    }

    public void saveTask(Task task) {
        if (task == null) throw new NullPointerException("Cannot find task");
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        if (task == null) throw new NullPointerException("Cannot find task");
        taskRepository.update(task);
    }

    public void deleteTask(Long id) {
        if (id < 0) throw new RuntimeException("Not an appropriate value");
        taskRepository.delete(id);
    }
}
