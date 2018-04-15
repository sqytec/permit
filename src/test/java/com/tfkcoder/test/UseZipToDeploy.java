package com.tfkcoder.test;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

public class UseZipToDeploy {
	public static void main(String[] args) {
		InputStream inStr = UseZipToDeploy.class.getClassLoader().getResourceAsStream("diagrams/2018.04.15.zip");
		ZipInputStream zipInputStream = new ZipInputStream(inStr);
		/*Deployment deploy = ProcessEngines.getDefaultProcessEngine().getRepositoryService().createDeployment().name("请假流程").addZipInputStream(zipInputStream).deploy();
		System.out.println("deploy: "+deploy.getName());*/
		List<ProcessDefinition> list = ProcessEngines.getDefaultProcessEngine()
				.getRepositoryService()
				.createProcessDefinitionQuery()
				.orderByProcessDefinitionVersion().asc()
				.list();
		for(ProcessDefinition pd:list){
			System.out.println("id: "+pd.getId());
			System.out.println("name: "+pd.getName());
			System.out.println("key: "+pd.getKey());
			System.out.println("verison: "+pd.getVersion());
			System.out.println("resourceName: "+pd.getResourceName());
			System.out.println("*-*");
		}
		
	}
}
