package com.htc.jdbc.main;


import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.htc.jdbc.config.JdbcConfig;
import com.htc.jdbc.dao.CattleDao;
import com.htc.jdbc.entity.Cattle;

public class JdbcTemplate {

	public static void main(String[] args) {
		
		ApplicationContext xmlContext = new ClassPathXmlApplicationContext("Jdbc.xml");
		cattleAddFromXmlApp(xmlContext);
		
		ApplicationContext beanConfigContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
		cattleOperationFromBeanConfig(beanConfigContext);
	}

	private static void cattleOperationFromBeanConfig(ApplicationContext beanConfigContext) {
		CattleDao cattleDao = (CattleDao) beanConfigContext.getBean("cattleDao");
		crudOperationForCattle(cattleDao);
	}

	private static void cattleAddFromXmlApp(ApplicationContext context) {
		CattleDao cattleDao = (CattleDao) context.getBean("cattleDao");
		crudOperationForCattle(cattleDao);
	}
	
	private static void crudOperationForCattle(CattleDao cattleDao) {
		Cattle cattle = new Cattle(51, new Date(), 100, new Date(), "Chennai", 1, false, 1, "immunity", "Tag01");
		cattleDao.addCattle(cattle);
		System.out.println("Added : "+cattle);
		List<Cattle> cattleList = cattleDao.getCattleList();
		System.out.println("Cattle List : "+ cattleList);
		cattleDao.getCattle(cattle.getCattleId());
		cattle.setOriginalArea("Bangalore");
		cattleDao.updateCattle(cattle);
		System.out.println("Updated : "+cattle);
		cattleDao.deleteCattle(cattle.getCattleId());
		System.out.println("Deleted : " +cattle.getCattleId());
	}

}
