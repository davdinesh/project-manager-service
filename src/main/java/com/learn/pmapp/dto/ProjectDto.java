/**
 * 
 */
package com.learn.pmapp.dto;

import java.util.Date;

/**
 * @author Senthil
 *
 */
public class ProjectDto {
	
	private int projectId;
	
	private String projectName;
	
	private Date projectStartDate;
	
	private Date projectEndDate;
	
	private int userId;
	
	private int priority;
	
	private int completedTasks;
	
	private int totalTasks;
	
	private String status;

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the projectStartDate
	 */
	public Date getProjectStartDate() {
		return projectStartDate;
	}

	/**
	 * @param projectStartDate the projectStartDate to set
	 */
	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	/**
	 * @return the projectEndDate
	 */
	public Date getProjectEndDate() {
		return projectEndDate;
	}

	/**
	 * @param projectEndDate the projectEndDate to set
	 */
	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * @return the completedTasks
	 */
	public int getCompletedTasks() {
		return completedTasks;
	}

	/**
	 * @param completedTasks the completedTasks to set
	 */
	public void setCompletedTasks(int completedTasks) {
		this.completedTasks = completedTasks;
	}

	/**
	 * @return the totalTasks
	 */
	public int getTotalTasks() {
		return totalTasks;
	}

	/**
	 * @param totalTasks the totalTasks to set
	 */
	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
