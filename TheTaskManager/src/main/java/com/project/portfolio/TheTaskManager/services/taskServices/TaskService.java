package com.project.portfolio.TheTaskManager.services.taskServices;

import com.project.portfolio.TheTaskManager.entities.Task;
import com.project.portfolio.TheTaskManager.entities.User;
import com.project.portfolio.TheTaskManager.repository.TasksDAO;
import com.project.portfolio.TheTaskManager.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TasksDAO tasksDAO;
    @Autowired
    private UserService userService;

    public List<Task> showAllTasks() {
        return tasksDAO.findAll();
    }

    public Optional<Task> getTaskById(Long taskId) {
        return tasksDAO.findById(taskId);
    }

    public boolean addTask(Task task) {
       if(task.getTitle().isEmpty() || task.getDescription().isEmpty()){
          return false;
    } else {
           tasksDAO.save(task);
           return true;
        }
    }







}



