/**
 * 
 */
package com.learn.pmapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learn.pmapp.model.Project;

/**
 * @author 137499
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	@Query("SELECT p from Project p where p.projectUser.userId = :userId")
	public List<Project> findProjectsByUserId(@Param("userId") int userId);

}
