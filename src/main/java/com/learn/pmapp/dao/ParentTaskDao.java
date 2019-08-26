/**
 * 
 */
package com.learn.pmapp.dao;

import java.util.List;

import com.learn.pmapp.model.ParentTask;

/**
 * @author 137499
 *
 */
public interface ParentTaskDao {

	public ParentTask findById(int parentId);

	public ParentTask save(ParentTask parentTask);

	public List<ParentTask> findAll();

}
