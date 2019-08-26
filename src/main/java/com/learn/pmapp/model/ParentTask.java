package com.learn.pmapp.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;


/**
 * The persistent class for the parent_task database table.
 * 
 */
@Entity
@Table(name="parent_task")
@NamedQuery(name="ParentTask.findAll", query="SELECT p FROM ParentTask p")
public class ParentTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="parent_id")
	private int parentId;

	@Column(name="parent_desc")
	private String parentDesc;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="parentTask")
	@JsonIgnore
	private Set<Task> tasks;

	public ParentTask() {
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getParentDesc() {
		return this.parentDesc;
	}

	public void setParentDesc(String parentDesc) {
		this.parentDesc = parentDesc;
	}

	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setParentTask(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setParentTask(null);

		return task;
	}

}