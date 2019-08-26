/**
 * 
 */
package com.learn.pmapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.TaskDao;
import com.learn.pmapp.model.Task;
import com.learn.pmapp.repository.TaskRepository;

/**
 * @author 137499
 *
 */
@Component
public class TaskDaoImpl implements TaskDao {
	
	@Autowired
	public TaskRepository taskRepository;

	@Override
	public Task save(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public Task findById(int id) {
		// TODO Auto-generated method stub
		return taskRepository.getOne(id);
	}

}