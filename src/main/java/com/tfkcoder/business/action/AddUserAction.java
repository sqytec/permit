package com.tfkcoder.business.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.tfkcoder.business.entity.User;
import com.tfkcoder.business.service.UserService;

@Controller
public class AddUserAction {
	@Autowired
	private UserService userService;

	private String username;

	private String password;

	private String message;

	public String execute() {

		userService.addUser(username, password);

		return Action.SUCCESS;
	}
	
	public String login() {

		if (username == null || password == null) {
			System.out.println("用户名或密码不能为空");
			return Action.ERROR;
		}

		User user = userService.login(username, password);
		if (user == null) {
			return Action.ERROR;
		} else {
			System.out.println(user);
			System.out.println("登陸成功！！");
		}
		return Action.SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
