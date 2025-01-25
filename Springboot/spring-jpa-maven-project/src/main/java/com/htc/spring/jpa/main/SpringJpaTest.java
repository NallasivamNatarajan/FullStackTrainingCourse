package com.htc.spring.jpa.main;

import java.util.Date;

import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.htc.spring.jpa.dao.CattleDao;
import com.htc.spring.jpa.dao.CattleDaoImpl;
import com.htc.spring.jpa.entity.Cattle;
import com.htc.spring.jpa.util.SpringJpaUtil;

public class SpringJpaTest {

	static Logger log = LogManager.getLogger(SpringJpaTest.class);

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = SpringJpaUtil.getEntityManagerFactory();
		CattleDao cattleDao = new CattleDaoImpl();
		doCrudOperationForCattle(cattleDao, entityManagerFactory);
		entityManagerFactory.close();
	}

	private static void doCrudOperationForCattle(CattleDao cattleDao, EntityManagerFactory entityManagerFactory) {
		Cattle cattle = new Cattle(22, new Date(), 100, new Date(), "Chennai", 1, false, 1, "immunity");
		cattleDao.addCattle(cattle, entityManagerFactory.createEntityManager());
		log.info("Cattle Information Added");
		cattleDao.getCattleList(entityManagerFactory.createEntityManager());
		log.info("Cattle List Information Loaded");
		cattleDao.getCattle(cattle.getCattleId(), entityManagerFactory.createEntityManager());
		cattle.setOriginalArea("Bangalore");
		cattleDao.updateCattle(cattle, entityManagerFactory.createEntityManager());
		log.info("Cattle Information Updated");
		cattleDao.deleteCattle(cattle.getCattleId(), entityManagerFactory.createEntityManager());
		log.warn("Cattle Information Deleted");
	}
}
