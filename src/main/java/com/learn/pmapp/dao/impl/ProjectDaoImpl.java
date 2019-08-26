/**
 * 
 */
package com.learn.pmapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.ProjectDao;
import com.learn.pmapp.model.Project;
import com.learn.pmapp.repository.ProjectRepository;

/**
 * @author 137499
 *
 */
@Component
public class ProjectDaoImpl implements ProjectDao {
	
	@Autowired
	public  ProjectRepository projectRepository;

	@Override
	public Project save(Project project) {
		// TODO Auto-generated method stub
		return projectRepository.save(project);
	}

	@Override
	public List<Project> findAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public void deleteProject(Project project) {
		// TODO Auto-generated method stub
		projectRepository.delete(project);
		
	}

	@Override
	public Project findById(int id) {
		// TODO Auto-generated method stub
		return projectRepository.getOne(id);
	}

	@Override
	public List<Project> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return projectRepository.findProjectsByUserId(userId);
	}

}
