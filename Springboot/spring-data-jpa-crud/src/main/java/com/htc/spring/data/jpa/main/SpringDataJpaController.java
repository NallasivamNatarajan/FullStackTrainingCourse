package com.htc.spring.data.jpa.main;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.htc.spring.data.jpa.config.SpringDataJpaConfig;
import com.htc.spring.data.jpa.entity.Cattle;
import com.htc.spring.data.jpa.service.CattleService;

public class SpringDataJpaController
{
	static Logger log = LogManager.getLogger(SpringDataJpaController.class);
	static ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataJpaConfig.class);
	static CattleService cattleService = (CattleService) context.getBean("cattleService");

    public static void main( String[] args )
    {
		
		  Cattle cattle = new Cattle(20, new Date(), 100, new Date(), "Chennai", 1,
		  false, 1, "immunity"); cattleService.addCattle(cattle);
		  log.info("Cattle Information Added"); cattleService.getAllCattle();
		  log.info("Cattle List Information Loaded");
		  cattleService.getCattleById(cattle.getCattleId());
		  log.info("Cattle Information Loaded"); cattle.setOriginalArea("Bangalore");
		  cattleService.updateCattle(cattle); log.info("Cattle Information Updated");
		  cattleService.deleteCattle(cattle.getCattleId());
		  log.warn("Cattle Information Deleted");
    }
    
}