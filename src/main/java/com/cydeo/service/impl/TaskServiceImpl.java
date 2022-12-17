package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }
    @Override
    public List<TaskDTO> listAllTasks() {
        List<TaskDTO> taskDTOList= taskRepository.findAll().stream().map(mapper::convertToDto).collect(Collectors.toList());
        return taskDTOList;}

    @Override
    public void save(TaskDTO taskDTO) {

        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        Task task = mapper.convertToEntity(taskDTO);
        taskRepository.save(task);}


    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskDTO update(TaskDTO taskDTO) {
        return null;
    }
}
