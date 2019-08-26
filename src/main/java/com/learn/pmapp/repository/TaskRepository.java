/**
 * 
 */
package com.learn.pmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.pmapp.model.Task;

/**
 * @author 137499
 *
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
	
	
}
