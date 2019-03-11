package com.entor.dao;

import java.util.List;

import com.entor.entity.User;



public interface UserDao {
public void add(User user);
	
	public void addMore(List<User> list);
	
	public void deleteById(int id);
	
	public void deleteMore(String ids);
	
	public void update(User user);
	
	public User queryById(int id);
	
	public List<User> queryAll();
	
	public List<User> queryByPage(int currentPage, int pageSize);
	
	public int getTotals();
}
