package com.example.david.services;

import com.example.david.model.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAllProjects();

    Project addProject(Project project);
    Project updateProject(Project project);
    void deleteProject(Long id);
}
