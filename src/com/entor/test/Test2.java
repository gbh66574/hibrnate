package com.entor.test;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entor.entity.User;
import com.entor.util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		Session s = HibernateUtil.getSession();
		/*
		 * // ����������ȡ������¼ // User u=(User)s.get(User.class, 1); User
		 * u=(User)s.load(User.class, 1); System.out.println(u);
		 */
		/*
		 * User u=new User(); u.setId(2); u.setName("����"); u.setUsername("lisi");
		 * u.setPassword("123"); u.setSex(0); u.setAge(22); u.setBirthday(new Date());
		 * u.setCreateTime(new Timestamp(System.currentTimeMillis())); Transaction
		 * tx=s.beginTransaction(); // s.save(u);
		 * s.saveOrUpdate(u);//������ݿ���ܴ�����Ӧ����������·������� tx.commit();
		 */
		Transaction tx = s.beginTransaction();
		// ɾ������
		s.delete(s.load(User.class, 1));
		tx.commit();
		s.close();
	}
}
