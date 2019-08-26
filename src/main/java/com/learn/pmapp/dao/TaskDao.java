/**
 * 
 */
package com.learn.pmapp.dao;

import java.util.List;

import com.learn.pmapp.model.Task;

/**
 * @author 137499
 *
 */
public interface TaskDao {
	
	public Task save(Task task);
	
	public List<Task> findAll();
	
	public Task findById(int id);
}
