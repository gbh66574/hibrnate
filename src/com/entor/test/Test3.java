package com.entor.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.entor.entity.User;
import com.entor.util.HibernateUtil;

public class Test3 {
public static void main(String[] args) {
		
		Session s = HibernateUtil.getSession();
		 Transaction tx=s.beginTransaction();
		/*Query query=s.createQuery("from User u where u.name like ?");//hql���from User�ȼ���sql����select * from user
		query.setString(0, "%��%");
		List<User>list=query.list();
		for(User u:list) {
			System.out.println(u);
		}
	*/
	/*	Random r=new Random();
		for(int i=1;i<=100;i++) {
			User user = new User();
			user.setId(i);
			user.setName("����"+i);
			user.setUsername("zhangsan"+i);
			user.setPassword("123456");
			user.setSex(r.nextInt(2));
			int age=r.nextInt(10)+20;
			user.setAge(age);
			Calendar c=Calendar.getInstance();
			c.add(Calendar.YEAR, -age);
			c.set(Calendar.MONDAY, r.nextInt(12));
			switch(c.get(Calendar.MONDAY)) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
			c.set(Calendar.DATE, r.nextInt(31)+1);
			break;
			case 4:
			case 6:
			case 9:
			case 11:
				c.set(Calendar.DATE, r.nextInt(30)+1);
				break;
			case 2:
				int year =c.get(Calendar.YEAR);
				if((year%4==0&&year%100==0)||year%400==0) {
					c.set(Calendar.DATE, r.nextInt(29)+1);
				}else {
					c.set(Calendar.DATE, r.nextInt(28)+1);

				}
			}
			user.setBirthday(c.getTime());
			user.setCreateTime(new Timestamp(System.currentTimeMillis()));
			s.save(user);
		}
		 tx.commit();*/
		 
		/* //��ѯ���ж��³�����ѧ������ʾ��һҳ
		 @SuppressWarnings("unchecked")
		 List<User>list=s.createQuery("from User u where extract(month from u.birthday)=?")
		.setInteger(0, 2)
		.setFirstResult(0)
		.setMaxResults(20)
		.list();
		for(User u:list) {
			System.out.println(u);
		}*/
		 //ͨ��Criteria��ѯ�����������25���Ůѧ������ʾ��һҳ
		/* Criteria c=s.createCriteria(User.class);//�ȼ���sql����select*from user
		 c.add(Restrictions.eq("sex", 0));//���sex=0��ѯ����
		 c.add(Restrictions.ge("age", 25));//���age>25��ѯ����
		 @SuppressWarnings("unchecked")
		 List<User>list=c.setFirstResult(0)
				 .setMaxResults(20)
				 .list();
		 for(User u:list) {
				System.out.println(u);
			}*/
		/* int totals=((Long)s.createQuery("select count(*) from User").uniqueResult()).intValue();
		 System.out.println(totals);*/
		//֧��sql��ѯ��䣬���صļ���װ����object[]
		List<User> list= s.createSQLQuery("select * from user").addEntity(User.class).list();
		for(User u:list) {
			System.out.println(u);
			
		}
//		 ����ɾ��
		/* s.createSQLQuery("delete from user where id in(1,2,3)").executeUpdate();*/
		s.close();
}


}
