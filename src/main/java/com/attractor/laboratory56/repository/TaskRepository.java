package com.attractor.laboratory56.repository;

import com.attractor.laboratory56.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, String> {
    public Iterable<Task> findTaskByUserId(String id);
    public List<Task> findAll();
    public Task findTaskById(String id);
    public List<Task> findAllById(String id);


}
