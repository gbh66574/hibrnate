package com.entor.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entor.dao.UserDao;
import com.entor.entity.User;
import com.entor.util.HibernateUtil;

public class UserDaoimpl implements UserDao {

	@Override
	public void add(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(user);
		tx.commit();
		s.close();
	}

	@Override
	public void addMore(List<User> list) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		for(User u:list) {
			s.save(u);
		}
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.delete(s.load(User.class, id));
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteMore(String ids) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		 s.createSQLQuery("delete from user where id in("+ids+")").executeUpdate();
		tx.commit();
		s.close();
		
	}

	@Override
	public void update(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
		
	}

	@Override
	public User queryById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User u=(User)s.get(User.class, 1);
		return u;
	}

	@Override
	public List<User> queryAll() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		List<User> list= s.createSQLQuery("select * from user").addEntity(User.class).list();
		return list;
	}

	@Override
	public List<User> queryByPage(int currentPage, int pageSize) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		 @SuppressWarnings("unchecked")
		 List<User>list=s.createQuery("from User")
					.setFirstResult((currentPage-1)*pageSize)
					.setMaxResults(pageSize)
					.list();
		return list;
	}

	@Override
	public int getTotals() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int totals=((Long)s.createSQLQuery("select count(*) from user").uniqueResult()).intValue();
		return totals;
	}

}
