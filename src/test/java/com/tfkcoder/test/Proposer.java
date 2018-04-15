package com.tfkcoder.test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.task.Task;

public class Proposer {
	public static void main(String[] args) {
		String taskStr = "zhangsan";
		String taskId  = "";

		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

		// list all task

		List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee(taskStr).list();
		for (Task task : list) {
			taskId = task.getId();
			// handle task
			processEngine.getTaskService().complete(taskId);
			System.out.println("complete task: "+task.getName());
		}


	}
}
