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

    public boolean addTaskToUser(Long userId, Task task){
        Optional<User> userOptional = userService.getUserById(userId);
        if(userOptional.isEmpty()){
            return false;
        }
        userOptional.get().addTask(task);
        tasksDAO.save(task);
         return true;
    }


     public boolean updateTask(Long taskId, Task updatedTask){
        Optional<Task> existingTaskOptional = tasksDAO.findById(taskId);

        if(existingTaskOptional.isPresent()){
            Task existingTask = existingTaskOptional.get();

            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setCompleted(updatedTask.getCompleted());

            tasksDAO.save(existingTask);
            return true;
        }
        return false;
    }
















}



