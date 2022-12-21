package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import com.cydeo.exception.TaskNotFoundException;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper mapper;
    private final ProjectMapper projectMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper mapper, ProjectMapper projectMapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        List<TaskDTO> taskDTOList = taskRepository.findAll().stream().map(mapper::convertToDto).collect(Collectors.toList());
        return taskDTOList;
    }

    @Override
    public TaskDTO findById(Long id) throws TaskNotFoundException {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return mapper.convertToDto(task.get());
        }
        throw new TaskNotFoundException("Task with id " + id + " not found");
    }


    @Override
    public void save(TaskDTO taskDTO) {

        taskDTO.setTaskStatus(Status.OPEN);
        taskDTO.setAssignedDate(LocalDate.now());
        Task task = mapper.convertToEntity(taskDTO);
        taskRepository.save(task);
    }


    @Override
    public void delete(Long id) {
        Optional<Task> foundTask = taskRepository.findById(id);
        if (foundTask.isPresent()) {
            foundTask.get().setIsDeleted(true);
            taskRepository.save(foundTask.get());
        }
    }

    @Override
    public void update(TaskDTO taskDTO) {
        Optional<Task> task = taskRepository.findById(taskDTO.getId());
        Task updatedTask = mapper.convertToEntity(taskDTO);

        if (task.isPresent()) {

            if (taskDTO.getTaskStatus() == null) {
                updatedTask.setTaskStatus(task.get().getTaskStatus());
            } else {
                updatedTask.setTaskStatus(taskDTO.getTaskStatus());
            }
            taskRepository.save(updatedTask);
        }
    }


    @Override
    public void deleteByProject(ProjectDTO projectDTO) {
        Project project = projectMapper.convertToEntity(projectDTO);
        List<Task> tasks = taskRepository.findAllByProject(project);
        tasks.forEach(task -> delete(task.getId()));

        }
    }

