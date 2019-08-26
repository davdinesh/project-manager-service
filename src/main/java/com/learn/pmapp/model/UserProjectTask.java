package com.learn.pmapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the user_project_task database table.
 * 
 */
@Entity
@Table(name="user_project_task")
@NamedQuery(name="UserProjectTask.findAll", query="SELECT u FROM UserProjectTask u")
public class UserProjectTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_project_task_id")
	private int userProjectTaskId;

	//bi-directional many-to-one association to Project
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User projectUser;

	//bi-directional many-to-one association to Task
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="task_id")
	private Task task;

	public UserProjectTask() {
	}

	public int getUserProjectTaskId() {
		return this.userProjectTaskId;
	}

	public void setUserProjectTaskId(int userProjectTaskId) {
		this.userProjectTaskId = userProjectTaskId;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getProjectUser() {
		return this.projectUser;
	}

	public void setProjectUser(User projectUser) {
		this.projectUser = projectUser;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}