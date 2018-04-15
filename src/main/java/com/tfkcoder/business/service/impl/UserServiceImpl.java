package com.tfkcoder.business.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfkcoder.business.dao.UserDao;
import com.tfkcoder.business.entity.User;
import com.tfkcoder.business.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user=userDao.selectByName(username);
		if(user == null){
			System.out.println("用户不存在");
		}
		if(!password.equals(user.getPassword())){
			System.out.println("密码不准确");
		}
		return user;
	}

	
	@Override
	public void addUser(String name, String passwd) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(name);
		user.setPassword(passwd);
		userDao.insert(user);
		
	}
	
	@Override
	public User selectById(Long id) {
		// TODO Auto-generated method stub
		
		return userDao.selectById(id);
	}
	
	@Override
	public User selectByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		
		return userDao.selectAllUser();
	}


	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	
	@Override
	public void updateUser(Long id, String name, String passwd) {
		// TODO Auto-generated method stub
		User user =new User();
		user.setId(id);
		user.setUsername(name);
		user.setPassword(passwd);
		userDao.update(user);
	}


	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.insert(user);
	}


}
