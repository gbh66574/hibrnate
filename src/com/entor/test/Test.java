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
		//��ȡ�Ự����
		 SessionFactory sessionFactory=cfg.buildSessionFactory();
		 //��ȡ�Ự����,�ȼ���jdbc�е�connection����
		 Session session=sessionFactory.openSession();
		 User user=new User();
		 user.setName("����");
		 user.setUsername("lisi");
		 user.setPassword("123456");
		 user.setSex(0);
		 user.setAge(22);
		 user.setBirthday(new Date());
		 user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		//��������
		 Transaction tx=session.beginTransaction();
		 //��������
		 session.save(user);
		 //�ύ����
		 tx.commit();
		 //�رջỰ
		 session.close();
		 
}
}
