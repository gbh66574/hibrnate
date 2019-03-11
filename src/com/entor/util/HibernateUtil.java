package com.entor.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sf;
static {
	Configuration cfg=new Configuration();
	cfg.configure("/hibernate.cfg.xml");
	//��ȡ�Ự����
	 sf=cfg.buildSessionFactory();
	 
}
//��ȡ�Ự����
public static SessionFactory getSessionFactory() {
	return sf;
}
//��ȡ�Ự����
public static Session getSession() {
	return sf.openSession();
}
}
