package com.entor.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sf;
static {
	Configuration cfg=new Configuration();
	cfg.configure("/hibernate.cfg.xml");
	//获取会话工厂
	 sf=cfg.buildSessionFactory();
	 
}
//获取会话工厂
public static SessionFactory getSessionFactory() {
	return sf;
}
//获取会话对象
public static Session getSession() {
	return sf.openSession();
}
}
