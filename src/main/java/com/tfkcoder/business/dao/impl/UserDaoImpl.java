package com.tfkcoder.business.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tfkcoder.business.dao.UserDao;
import com.tfkcoder.business.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User selectById(Long id) {
		// TODO Auto-generated method stub
		String hql="from User u where u.id=?";
		Query query = this.getSession().createQuery(hql);
		query.setLong(0, id);
		return (User) query.uniqueResult();
	}

	@Override
	public User selectByName(String username) {
		// TODO Auto-generated method stub
		String hql="from User u where u.username=?";
		Query query = this.getSession().createQuery(hql);
		Logger logger = Logger.getLogger(UserDaoImpl.class);
		logger.info("-------------query:"+query);
		query.setString(0, username);
		logger.info("-----------retMessage:"+(User)query.uniqueResult());
		return (User)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		String hql="from User";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		this.getSession().save(user);
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		String hql="delete User u where u.id=?";
		Query query = this.getSession().createQuery(hql);
		query.setLong(0, id);
		query.executeUpdate();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.getSession().saveOrUpdate(user);
		
	}
	
}
