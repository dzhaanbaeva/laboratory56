package com.attractor.laboratory56.service;

import com.attractor.laboratory56.dto.TaskDTO;
import com.attractor.laboratory56.model.ResultTask;
import com.attractor.laboratory56.model.Task;
import com.attractor.laboratory56.model.User;
import com.attractor.laboratory56.repository.TaskRepository;
import com.attractor.laboratory56.repository.UserRepository;
import lombok.var;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public Iterable<Task> selectPublicationsByUserId(String id) {
        return taskRepo.findTaskByUserId(id);
    }

    public Task setTask(TaskDTO taskData) {
        return taskRepo.save(new Task(taskData.headline, taskData.description, taskData.performanceDate, this.getUser()));
    }

    public Task findTaskById(String id) {
        Task task = taskRepo.findTaskById(id);
        if (task.getStatus().equalsIgnoreCase("new")) {
            task.setStatus("in work");
        } else if (task.getStatus().equalsIgnoreCase("in work")) {
            task.setStatus("finished");
        }
        return taskRepo.save(task);

    }

    public List<ResultTask> getTask() {
        var result = taskRepo.findAll().stream().filter(s -> s.getUser().getUsername().equals(this.getUser().getUsername())).collect(Collectors.toList());
        List<ResultTask> st = new ArrayList<>();
        result.stream().map(s -> st.add(new ResultTask(s.getId(), s.getHeadline(), s.getPerformanceDate()))).collect(Collectors.toList());
        return st;
    }
    public List<Task> getTaskById(String id) {
        return taskRepo.findAllById(id).stream().filter(s -> s.getUser().getUsername().equals(this.getUser().getUsername())).collect(Collectors.toList());
    }

    private User getUser() {
        // get current authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByUsername(auth.getName()).get();
    }
}


