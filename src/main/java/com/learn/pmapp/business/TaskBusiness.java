/**
 * 
 */
package com.learn.pmapp.business;

import java.util.List;

import com.learn.pmapp.dto.TaskDto;
import com.learn.pmapp.model.ParentTask;
import com.learn.pmapp.model.Task;

/**
 * @author 137499
 *
 */
public interface TaskBusiness {
	
	public TaskDto save(TaskDto task);
	
	public List<Task> findAll();
	
	public Task findById(int id);

	public ParentTask addParentTask(ParentTask parentTask);

	public Task save(Task taskExist);

	public TaskDto update(TaskDto task);

	public List<TaskDto> viewTasks();

	public List<ParentTask> viewParentTasks();
	
}
