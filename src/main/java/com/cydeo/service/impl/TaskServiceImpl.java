package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public List<TaskDTO> listAllTasks() {
        return null;
    }

    @Override
    public void save(TaskDTO taskDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        return null;
    }
}
