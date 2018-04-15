package com.tfkcoder.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

public class Test {
	public static void main(String[] args) {
		String deploymentId = "";
		String name = "";
		ProcessEngine processEngine = null;
		RepositoryService repositoryService  = null;
		Deployment deployment = null;
		ProcessDefinition singleResult  = null;
		ProcessInstance processInstance = null;
		
		
		//getDefaultProcessEngine 可以获取到默认的配置文件 activiti.cfg.xml
		processEngine = ProcessEngines.getDefaultProcessEngine();

		// repositoryService 指process 的bpmn和png两个文件
		repositoryService = processEngine.getRepositoryService();
		// DeploymentBuilder   定义 process deployment 相关参数
		deployment = repositoryService.createDeployment().name("Leave Process")
				.addClasspathResource("diagrams/LeaveProcess.bpmn")
				.addClasspathResource("diagrams/LeaveProcess.png").deploy();
		//deployment.getId()  可以获取到Activity生成的表 act_ge_bytearray中DEPLOYMENT_ID_值
		System.out.println("------deployment id:" + deployment.getId() + ",deployment name: " + deployment.getName());
		
		//ProcessDefinition是一个流程定义类，可以从这里获取一些资源文件
		singleResult = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
		//ProcessInstance 代表流程定义的执行实例,使用startProcessInstanceById 来查询
		deploymentId = singleResult.getId();
		System.out.println("singleResult.getId():"+deploymentId+",singleResult.getDeploymentId()："+singleResult.getDeploymentId());
		processInstance = processEngine.getRuntimeService().startProcessInstanceById(deploymentId);
		
		//使用startProcessInstanceByKey 来查询
		name = singleResult.getKey();
		System.out.println("singleResult.getKey(): "+name);
		processInstance = processEngine.getRuntimeService().startProcessInstanceByKey(name);
		System.out.println("------processInstance id: "+processInstance.getId()+",activiti id: "+processInstance.getActivityId());
		
		
		// 删除流程deplomentId
		// repositoryService.deleteDeployment(deplomentId);

		// 执行管理，包括启动、推进、删除流程实例等操作(是activiti的流程执行服务类,可以从这个服务类中获取很多关于流程执行相关的信息)
		// RuntimeService runtimeService = processEngine.getRuntimeService();

		// 任务管理（是activiti的任务服务类，可以从这个类中获取任务的信息）
		// TaskService taskService = processEngine.getTaskService();

		// 历史管理(执行完的数据的管理) 是activiti的查询历史信息的类，在一个流程执行完成后，这个对象为我们提供查询历史信息。
		// HistoryService historyService = processEngine.getHistoryService();

		// 组织机构管理
		// IdentityService identityService = processEngine.getIdentityService();
		// 一个可选服务，任务表单管理
		// FormService formService = processEngine.getFormService();

		// ManagementService managementService =
		// processEngine.getManagementService();
	}
}
