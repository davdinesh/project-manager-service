/**
 * 
 */
package com.learn.pmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.pmapp.business.ProjectBusiness;
import com.learn.pmapp.business.TaskBusiness;
import com.learn.pmapp.business.UserBusiness;
import com.learn.pmapp.dao.ParentTaskDao;
import com.learn.pmapp.dao.StatusDao;
import com.learn.pmapp.dto.TaskDto;
import com.learn.pmapp.model.ParentTask;
import com.learn.pmapp.model.Task;

/**
 * @author 137499
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/task")
@RestController
public class TaskController {
	
	@Autowired
	public TaskBusiness taskBusiness;
	
	@Autowired
	public UserBusiness userBusiness;
	
	@Autowired
	public ProjectBusiness projectBusiness;
	
	@Autowired
	public ParentTaskDao parentTaskDao;
	
	@Autowired		
	public StatusDao statusDao;
	
	/**
	 * 
	 * @param projectId
	 * @param userId
	 * @param parentId
	 * @param statusId
	 * @param task
	 * @return
	 */
	/*@PostMapping("/add/{projectId}/{userId}/{parentId}/{statusId}")
	public Task addTask(@PathVariable(value = "projectId") int projectId, 
			@PathVariable(value = "userId") int userId,
			@PathVariable(value = "parentId") int parentId, 
			@PathVariable(value = "statusId") int statusId,
			@RequestBody Task task) {
		return taskBusiness.save(task, projectId, userId, parentId, statusId);
	}*/
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/")
	public List<Task> findAll() {
		return taskBusiness.findAll();
	}
	
	@PostMapping("/addNewTask")
	public TaskDto addTask(@RequestBody TaskDto taskDto) {
		return taskBusiness.save(taskDto);
	}
	
	@PostMapping("/updateTask")
	public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
		Task task  = taskBusiness.findById(taskDto.getTaskId());
		if (task == null) {
			return ResponseEntity.notFound().build();
		}
		
		TaskDto taskDtoUpdated  = taskBusiness.update(taskDto);
		
		return ResponseEntity.ok().body(taskDtoUpdated);
	}
	
	@GetMapping("/getAllTasks")
	public List<TaskDto> viewTasks() {
		return taskBusiness.viewTasks();
	}
	
	@GetMapping("/getAllParentTasks")
	public List<ParentTask> viewParentTasks() {
		return taskBusiness.viewParentTasks();
	}
	
	/**
	 * 
	 * @param parentTask
	 * @return
	 */
	@PostMapping("/addParentTask")
	public ParentTask addParentTask(@RequestBody ParentTask parentTask) {
		return taskBusiness.addParentTask(parentTask);
	}
	
	/**
	 * 
	 * @param id
	 * @param projectId
	 * @param userId
	 * @param parentId
	 * @param statusId
	 * @param task
	 * @return
	 */
	/*@PutMapping("/update/{id}/{projectId}/{userId}/{parentId}/{statusId}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") int id,
			@PathVariable(value = "projectId") int projectId, 
			@PathVariable(value = "userId") int userId,
			@PathVariable(value = "parentId") int parentId, 
			@PathVariable(value = "statusId") int statusId,
			@RequestBody Task task) {
		Task taskExist = taskBusiness.findById(id);
		if (taskExist == null) {
			return ResponseEntity.notFound().build();
		}

		setTaskEntity(projectId, userId, parentId, statusId, task, taskExist);

		Task taskUpdated = taskBusiness.save(taskExist);

		return ResponseEntity.ok().body(taskUpdated);
	}
	
	*//**
	 * 
	 * @param projectId
	 * @param userId
	 * @param parentId
	 * @param statusId
	 * @param task
	 * @param taskExist
	 *//*
	private void setTaskEntity(int projectId, int userId, int parentId, int statusId, Task task, Task taskExist) {
		taskExist.setStartDate(task.getStartDate());
		taskExist.setEndDate(task.getEndDate());
		taskExist.setPriorityId(task.getPriorityId());
		taskExist.setTaskDesc(task.getTaskDesc());
		taskExist.setProject(projectBusiness.findById(projectId));
		taskExist.setParentTask(parentTaskDao.findById(parentId));
		taskExist.setProjectUser(userBusiness.findById(userId));
		taskExist.setStatus(statusDao.findById(statusId));
	}
*/
}
