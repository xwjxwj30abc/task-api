package zx.soft.task.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zx.soft.task.api.dao.TaskMapper;
import zx.soft.task.api.domain.Task;

/**
 * 全网任务服务类
 *
 * @author wanggang
 *
 */
@Service
public class TaskService {

	@Inject
	private TaskMapper taskMapper;

	/**
	 * 插入任务
	 */
	public void insertTasks(List<Task> tasks) {
		for (Task task : tasks) {
			insertTask(task);
		}
	}

	private void insertTask(Task task) {
		taskMapper.insertTask(task);
	}

	/**
	 * 删除任务
	 */
	public void deleteTasks(String identifys) {
		for (String identify : identifys.split(",")) {
			deleteTask(identify);
		}
	}

	private void deleteTask(String identify) {
		taskMapper.deleteTask(identify);
	}

	/**
	 * 查询任务
	 */
	public List<Task> selectTasks(String identifys) {
		List<Task> tasks = new ArrayList<>();
		Task tmp = null;
		for (String identify : identifys.split(",")) {
			tmp = selectTask(identify);
			if (tmp != null) {
				tasks.add(tmp);
			}
		}
		return tasks;
	}

	private Task selectTask(String identify) {
		return taskMapper.selectTask(identify);
	}

	/**
	 * 修改任务
	 */
	public void updateTasks(List<Task> tasks) {
		for (Task task : tasks) {
			updateTask(task);
		}
	}

	private void updateTask(Task task) {
		taskMapper.updateTask(task);
	}

}
