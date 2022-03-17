package com.example.david.controller;

import com.example.david.model.Project;
import com.example.david.repository.ProjectRepo;
import com.example.david.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projects = projectService.findAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        Project newProject = projectService.addProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        Project updateProject = projectService.updateProject(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
