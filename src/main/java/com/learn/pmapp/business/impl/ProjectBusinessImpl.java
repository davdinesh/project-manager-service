/**
 * 
 */
package com.learn.pmapp.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.business.ProjectBusiness;
import com.learn.pmapp.dao.ProjectDao;
import com.learn.pmapp.dao.TaskDao;
import com.learn.pmapp.dao.UserDao;
import com.learn.pmapp.dto.ProjectDto;
import com.learn.pmapp.model.Project;
import com.learn.pmapp.model.Task;
import com.learn.pmapp.model.User;

/**
 * @author 137499
 *
 */
@Component
public class ProjectBusinessImpl implements ProjectBusiness {
	
	@Autowired
	public ProjectDao projectDao;
	
	@Autowired
	public TaskDao taskDao;
	
	@Autowired
	public UserDao userDao;
	

	@Override
	public ProjectDto save(ProjectDto projectDto) {
		
		Project project  = null;
		if (projectDto.getProjectId() == 0) {
			project = new Project();
			project.setProjectDesc(projectDto.getProjectName());
			project.setStartDate(projectDto.getProjectStartDate());
			project.setEndDate(projectDto.getProjectEndDate());
			project.setPriorityId(projectDto.getPriority());
			User user = userDao.findById(projectDto.getUserId());
			if (user != null) {
				project.setProjectUser(user);
			}
		} else {
			project = projectDao.findById(projectDto.getProjectId());
			if (project == null) {
				
			}
			project.setProjectDesc(projectDto.getProjectName());
			project.setStartDate(projectDto.getProjectStartDate());
			project.setEndDate(projectDto.getProjectEndDate());
			project.setPriorityId(projectDto.getPriority());
			User user = userDao.findById(projectDto.getUserId());
			if (user != null) {
				project.setProjectUser(user);
			}
			
		}
		
		Project updatedProj = projectDao.save(project);
		ProjectDto dtoFinal  = new ProjectDto();
		dtoFinal.setProjectId( updatedProj.getProjectId());
		dtoFinal.setProjectStartDate(updatedProj.getStartDate());
		dtoFinal.setProjectEndDate(updatedProj.getEndDate());
		dtoFinal.setPriority(updatedProj.getPriorityId());
		dtoFinal.setUserId(updatedProj.getProjectUser().getUserId());
		dtoFinal.setProjectName(updatedProj.getProjectDesc());
		return dtoFinal;
	}

	@Override
	public List<Project> findAll() {

		return projectDao.findAll();
	}

	
	@Override
	public void deleteProject(Project project) {
		projectDao.deleteProject(project);
	}

	
	@Override
	public Project findById(int id) {

		return projectDao.findById(id);
	}

	@Override
	public List<ProjectDto> viewProjects() {
		// TODO Auto-generated method stub
		List<Project> projects = projectDao.findAll();
		List<ProjectDto> projectDtos = new ArrayList<ProjectDto>();
		for (Project project : projects) {
			ProjectDto dtoProject = new ProjectDto();
			dtoProject.setProjectId(project.getProjectId());
			dtoProject.setProjectName(project.getProjectDesc());
			dtoProject.setProjectStartDate(project.getStartDate());
			dtoProject.setProjectEndDate(project.getEndDate());
			dtoProject.setPriority(project.getPriorityId());
			List<Task> completedTasks = project.getTasks().stream()
					.filter((task) -> task.getStatus().getStatusDesc().equals("Completed"))
					.collect(Collectors.toList());
			List<Task> suspendedTasks = project.getTasks().stream()
					.filter((task) -> task.getStatus().getStatusDesc().equals("Suspended"))
					.collect(Collectors.toList());
			dtoProject.setCompletedTasks(completedTasks.size());
			dtoProject.setTotalTasks(project.getTasks().size());
			if (completedTasks.size() == project.getTasks().size() && completedTasks.size() != 0) {
				dtoProject.setStatus("Completed");
			} else if (suspendedTasks.size() > 0) {
				dtoProject.setStatus("Suspended");
			}
			dtoProject.setUserId(project.getProjectUser() != null ? project.getProjectUser().getUserId() : 0);
			projectDtos.add(dtoProject);
		}
		return projectDtos;
	}
	
}