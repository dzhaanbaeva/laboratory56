package com.attractor.laboratory56.controller;

import com.attractor.laboratory56.dto.TaskDTO;
import com.attractor.laboratory56.model.ResultTask;
import com.attractor.laboratory56.model.Task;
import com.attractor.laboratory56.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public List<ResultTask> getTask() {
        return taskService.getTask();
    }

    @GetMapping("/task/{id}")
    public List<Task> getTaskId(@PathVariable String id) {

        return taskService.getTaskById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task addTask(@RequestBody TaskDTO taskData) {
        return taskService.setTask(taskData);
    }

    @PostMapping("/status/{id}")
    public Task changeStatus(@PathVariable String id) {
        return taskService.findTaskById(id);
    }



}
