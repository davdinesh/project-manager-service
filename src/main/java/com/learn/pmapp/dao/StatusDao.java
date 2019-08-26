package com.learn.pmapp.dao;

import java.util.List;

import com.learn.pmapp.model.Status;

public interface StatusDao {
	
	public List<Status> findAll();
	
	public Status findById(int id);

}
