package com.tfkcoder.business.dao;

import java.util.List;

import com.tfkcoder.business.entity.User;

public interface UserDao {
	User selectById(Long id);

	User selectByName(String username);

	List<User> selectAllUser();

	void insert(User user);

	void deleteById(Long id);

	void update(User user);
}
