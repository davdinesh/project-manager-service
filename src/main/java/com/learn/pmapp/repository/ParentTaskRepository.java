/**
 * 
 */
package com.learn.pmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.pmapp.model.ParentTask;

/**
 * @author 137499
 *
 */
public interface ParentTaskRepository extends JpaRepository<ParentTask, Integer> {

}
