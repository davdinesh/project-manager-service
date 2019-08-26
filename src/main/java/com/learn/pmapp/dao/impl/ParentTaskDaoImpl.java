/**
 * 
 */
package com.learn.pmapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.ParentTaskDao;
import com.learn.pmapp.model.ParentTask;
import com.learn.pmapp.repository.ParentTaskRepository;

/**
 * @author 137499
 *
 */
@Component
public class ParentTaskDaoImpl implements ParentTaskDao {
	
	@Autowired
	public ParentTaskRepository parentTaskRepository;

	@Override
	public ParentTask findById(int parentId) {
		// TODO Auto-generated method stub
		return parentTaskRepository.getOne(parentId);
	}

	@Override
	public ParentTask save(ParentTask parentTask) {
		// TODO Auto-generated method stub
		return parentTaskRepository.save(parentTask);
	}

	@Override
	public List<ParentTask> findAll() {
		// TODO Auto-generated method stub
		return parentTaskRepository.findAll();
	}
	
	

}
