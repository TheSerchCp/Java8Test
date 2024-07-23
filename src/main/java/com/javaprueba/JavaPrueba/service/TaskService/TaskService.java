package com.javaprueba.JavaPrueba.service.TaskService;

import com.javaprueba.JavaPrueba.mapper.task.TaskMapper;
import com.javaprueba.JavaPrueba.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> findAll() {
        return taskMapper.selectAll();
    }

    public int save(Task task) {
            return taskMapper.insert(task);
    }
}
