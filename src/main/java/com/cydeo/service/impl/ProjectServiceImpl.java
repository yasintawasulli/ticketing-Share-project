package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final TaskService taskService;
    private final ProjectRepository projectRepository;

    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(TaskService taskService
            , ProjectRepository projectRepository
            , ProjectMapper projectMapper) {
        this.taskService = taskService;
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> listAllProjects() {
        List<Project>listAllProjects=projectRepository.findAll();
       return listAllProjects.stream().map(projectMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void save(ProjectDTO projectDTO) {
        projectDTO.setProjectStatus(Status.OPEN);
        Project project = projectMapper.convertToEntity(projectDTO);
        projectRepository.save(project);

    }

    @Override
    public void delete(String projectCode) {

        Project project = projectRepository.findByProjectCode(projectCode);
        project.setIsDeleted(true);

        project.setProjectCode(project.getProjectCode() + "-" + project.getId());

        projectRepository.save(project);

//        taskService.deleteByProject(projectMapper.convertToDto(project));


    }

    @Override
    public void update(ProjectDTO projectDTO) {

        Project project = projectRepository.findByProjectCode(projectDTO.getProjectCode());

        Project convertedProject = projectMapper.convertToEntity(projectDTO);

        convertedProject.setId(project.getId());

        convertedProject.setProjectStatus(project.getProjectStatus());

        projectRepository.save(convertedProject);
    }

    @Override
    public ProjectDTO getByProjectCode(String projectCode) {
        Project project = projectRepository.findByProjectCode(projectCode);
        return projectMapper.convertToDto(project);
    }




}
