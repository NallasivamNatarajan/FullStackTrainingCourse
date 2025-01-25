package com.htc.hibernate.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

	private MySessionFactory() {
	}

	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		return configuration.buildSessionFactory();
	}

}
