/**
 * 
 */
package com.learn.pmapp.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learn.pmapp.business.ProjectBusiness;
import com.learn.pmapp.business.TaskBusiness;
import com.learn.pmapp.business.UserBusiness;
import com.learn.pmapp.dao.ParentTaskDao;
import com.learn.pmapp.dao.StatusDao;
import com.learn.pmapp.dao.TaskDao;
import com.learn.pmapp.dto.TaskDto;
import com.learn.pmapp.model.ParentTask;
import com.learn.pmapp.model.Project;
import com.learn.pmapp.model.Status;
import com.learn.pmapp.model.Task;
import com.learn.pmapp.model.User;

/**
 * @author 137499
 *
 */
@Component
public class TaskBusinessImpl implements TaskBusiness {
	
	@Autowired
	public TaskDao taskDao;
	
	@Autowired
	public ParentTaskDao parentTaskDao;
	
	@Autowired
	public UserBusiness userBusiness;
	
	@Autowired
	public ProjectBusiness projectBusiness;
	
	@Autowired
	public StatusDao statusDao;
	

	@Override
	public TaskDto save(TaskDto taskDto) {
		ParentTask parent = null;
		User user = userBusiness.findById(taskDto.getTaskUserId());
		if (taskDto.getParentId() > 0) {
			parent = parentTaskDao.findById(taskDto.getParentId());
		}
		Project project = projectBusiness.findById(taskDto.getProjectId());
		Status status = statusDao.findById(taskDto.getTaskStatusId());
		Task  task  = new Task();
		task.setProjectUser(user); 
		task.setProject(project);
		task.setParentTask(parent);
		task.setStatus(status);
		task.setPriorityId(taskDto.getPriority());
		task.setTaskDesc(taskDto.getTaskName());
		task.setStartDate(taskDto.getTaskStartDate());
		task.setEndDate(taskDto.getTaskEndDate());
		Task taskUpdated = taskDao.save(task);
		taskDto.setTaskId(taskUpdated.getTaskId());
		return taskDto;
	}

	
	@Override
	public TaskDto update(TaskDto taskDto) {
		ParentTask parent = null;
		User user = userBusiness.findById(taskDto.getTaskUserId());
		if (taskDto.getParentId() > 0) {
			parent = parentTaskDao.findById(taskDto.getParentId());
		}
		//Project project = projectBusiness.findById(taskDto.getProjectId());
		Status status = statusDao.findById(taskDto.getTaskStatusId());
		Task task = taskDao.findById(taskDto.getTaskId());
		task.setProjectUser(user); 
		//task.setProject(project);
		task.setParentTask(parent);
		task.setStatus(status);
		task.setPriorityId(taskDto.getPriority());
		task.setTaskDesc(taskDto.getTaskName());
		task.setStartDate(taskDto.getTaskStartDate());
		task.setEndDate(taskDto.getTaskEndDate());
		taskDao.save(task);
		
		return taskDto;
	}
	
	@Override
	public List<Task> findAll() {
		return taskDao.findAll();
	}

	@Override
	public Task findById(int id) {
		return taskDao.findById(id);
	}

	@Override
	public ParentTask addParentTask(ParentTask parentTask) {
		return parentTaskDao.save(parentTask);
	}
	
	@Override
	public List<ParentTask> viewParentTasks() {
		return parentTaskDao.findAll();
	}

	@Override
	public Task save(Task task) {
		return taskDao.save(task);
	}


	@Override
	public List<TaskDto> viewTasks() {
		List<Task> tasks = taskDao.findAll();
		List<TaskDto> taskDtos = new ArrayList<TaskDto>();
		for (Task task: tasks) {
			TaskDto dtoTask = new TaskDto();
			dtoTask.setTaskId(task.getTaskId());
			dtoTask.setTaskName(task.getTaskDesc());
			dtoTask.setParentId(task.getParentTask() != null  ? task.getParentTask().getParentId() : 0);
			dtoTask.setParentDesc(task.getParentTask() != null ? task.getParentTask().getParentDesc(): null);
			dtoTask.setProjectId(task.getProject().getProjectId());
			dtoTask.setProjectDesc(task.getProject().getProjectDesc());
			dtoTask.setTaskUserId(task.getProjectUser() != null? task.getProjectUser().getUserId() : 0);
			dtoTask.setUserName(task.getProjectUser() != null? task.getProjectUser().getFirstName() + ' ' + task.getProjectUser().getLastName() : null);
			dtoTask.setTaskStartDate(task.getStartDate());
			dtoTask.setTaskEndDate(task.getEndDate());
			dtoTask.setTaskStatusId(task.getStatus().getStatusId());
			dtoTask.setTaskStatus(task.getStatus().getStatusDesc());
			taskDtos.add(dtoTask);
		}
		
		return taskDtos;
	}

	

}
