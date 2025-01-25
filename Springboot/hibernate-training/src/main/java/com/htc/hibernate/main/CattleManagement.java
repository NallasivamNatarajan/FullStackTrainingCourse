package com.htc.hibernate.main;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.htc.hibernate.dao.CattleDao;
import com.htc.hibernate.dao.CattleDaoImpl;
import com.htc.hibernate.entity.Cattle;

public class CattleManagement {
	
	static Logger log = LogManager.getLogger(CattleManagement.class);

	public static void main(String[] args) {
		CattleDao cattleDao = new CattleDaoImpl();
		doCrudOperationForCattle(cattleDao);
	}

	private static void doCrudOperationForCattle(CattleDao cattleDao) {
		Cattle cattle = new Cattle(1, new Date(), 100, new Date(), "Chennai", 1, false, 1, "immunity");
		cattleDao.addCattle(cattle);
		log.info("Cattle Information Added");
		cattleDao.getCattleList();
		log.info("Cattle List Information Loaded");
		cattleDao.getCattle(cattle.getCattleId());
		log.info("Cattle Information Loaded");
		cattle.setOriginalArea("Bangalore");
		cattleDao.updateCattle(cattle);
		log.info("Cattle Information Updated");
		cattleDao.deleteCattle(cattle);
		log.info("Cattle Information Deleted");
	}
}
