package com.tampro.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionUtil {
private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml")
				.applySettings(configuration.getProperties()).build();
		sessionFactory =  configuration.buildSessionFactory(registry);
		}
		return sessionFactory;
	}

}
