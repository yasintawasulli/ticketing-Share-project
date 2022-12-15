package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> listAllProjects();

    void save(ProjectDTO projectDTO);

    void delete(String projectCode);

    ProjectDTO update(ProjectDTO projectDTO);
}