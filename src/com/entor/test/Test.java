package com.entor.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entor.entity.User;

public class Test {
	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		//获取会话工厂
		 SessionFactory sessionFactory=cfg.buildSessionFactory();
		 //获取会话对象,等价于jdbc中的connection对象
		 Session session=sessionFactory.openSession();
		 User user=new User();
		 user.setName("李四");
		 user.setUsername("lisi");
		 user.setPassword("123456");
		 user.setSex(0);
		 user.setAge(22);
		 user.setBirthday(new Date());
		 user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		//开启事务
		 Transaction tx=session.beginTransaction();
		 //保存数据
		 session.save(user);
		 //提交事务
		 tx.commit();
		 //关闭会话
		 session.close();
		 
}
}
