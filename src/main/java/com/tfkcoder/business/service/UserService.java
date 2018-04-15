package com.tfkcoder.business.service;

import java.util.List;

import com.tfkcoder.business.entity.User;

public interface UserService {
	
	User login(String username,String password);
	
	void addUser(String name,String passwd);
	
	void updateUser(Long id,String name,String passwd);
	
    User selectById(Long id);
    
    User selectByName(String username);
    
    List<User> selectAllUser();
	
	void insert(User user);
	
	void deleteById(Long id);
	
	void addUser(User user);

}