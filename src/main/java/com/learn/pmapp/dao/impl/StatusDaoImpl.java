/**
 * 
 */
package com.learn.pmapp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.dao.StatusDao;
import com.learn.pmapp.model.Status;
import com.learn.pmapp.repository.StatusRepository;

/**
 * @author 141446
 *
 */
@Component
public class StatusDaoImpl implements StatusDao {
	
	@Autowired
	public StatusRepository statusRepository;

	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return statusRepository.findAll();
	}

	@Override
	public Status findById(int id) {
		// TODO Auto-generated method stub
		return statusRepository.getOne(id);
	}

}
