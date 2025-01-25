package com.htc.spring.jpa.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SpringJpaUtil {
	
	private SpringJpaUtil(){}

	public static EntityManagerFactory getEntityManagerFactory() {

		return Persistence.createEntityManagerFactory("myunit");
	}

}
