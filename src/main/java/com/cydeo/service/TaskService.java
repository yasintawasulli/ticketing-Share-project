package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.exception.TaskNotFoundException;


import java.util.List;

public interface TaskService {

    List<TaskDTO> listAllTasks();

    TaskDTO findById(Long id) throws TaskNotFoundException;

    void save(TaskDTO taskDTO);

    void delete(Long id);

    void update(TaskDTO taskDTO);

    void deleteByProject(ProjectDTO projectDTO);

}
