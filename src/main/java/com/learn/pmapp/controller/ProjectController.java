package com.learn.pmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.pmapp.business.ProjectBusiness;
import com.learn.pmapp.business.UserBusiness;
import com.learn.pmapp.dto.ProjectDto;
import com.learn.pmapp.model.Project;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	public ProjectBusiness projectBusiness;
	
	@Autowired
	public UserBusiness userBusiness;
	

	@PostMapping("/add")
	public ProjectDto addProject(@RequestBody ProjectDto projectDto) {
		return projectBusiness.save(projectDto);
	}
	
	@GetMapping("/")
	public List<Project> fetchAllProjects() {
		
		return projectBusiness.findAll(); 
	}
	
	@GetMapping("/getAllProjects")
	public List<ProjectDto> viewProjects() {
		return projectBusiness.viewProjects();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value="id") int id, @RequestBody ProjectDto projectDto) {
		Project proj = projectBusiness.findById(id);
		if (proj == null) {
			return ResponseEntity.notFound().build();
		}
		ProjectDto projUpdated = projectBusiness.save(projectDto);
		
		return ResponseEntity.ok().body(projUpdated);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Project> deleteProject(@PathVariable(value="id") int id) {
		
		Project emp = projectBusiness.findById(id);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		projectBusiness.deleteProject(emp);
		return ResponseEntity.ok().build();
		
	}
	

}
