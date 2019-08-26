/**
 * 
 */
package com.learn.pmapp.dao;

import java.util.List;

import com.learn.pmapp.model.Project;

/**
 * @author 137499
 *
 */
public interface ProjectDao {
	
	public Project save(Project project);
	
	public List<Project> findAll();
	
	public void deleteProject(Project project);

	public Project findById(int id);
	
	public List<Project> findByUserId(int userId);

}
