package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public List<ProjectDTO> listAllProjects() {
        return null;
    }

    @Override
    public void save(ProjectDTO projectDTO) {

    }

    @Override
    public void delete(String projectCode) {

    }

    @Override
    public ProjectDTO update(ProjectDTO projectDTO) {
        return null;
    }
}
