package com.example.david.services.impl;

import com.example.david.model.Project;
import com.example.david.repository.ProjectRepo;
import com.example.david.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ProjectingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepo projectRepo;

    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo){
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepo.save(project);
    }

    public void deleteProject(Long id){
        projectRepo.deleteProjectById(id);
    }
}
