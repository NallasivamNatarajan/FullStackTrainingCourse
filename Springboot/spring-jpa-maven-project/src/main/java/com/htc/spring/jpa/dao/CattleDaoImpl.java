package com.htc.spring.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.htc.spring.jpa.entity.Cattle;

public class CattleDaoImpl implements CattleDao {

	static Logger log = LogManager.getLogger(CattleDaoImpl.class);

	public boolean addCattle(Cattle cattle, EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(cattle);
		entityTransaction.commit();
		log.info("Cattle Added Successfully");
		entityManager.close();
		return true;
	}

	public Cattle getCattle(int cattleId, EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Cattle bk = entityManager.find(Cattle.class, cattleId);
		entityTransaction.commit();
		log.info("Fetched Cattle Successfully");
		entityManager.close();
		return bk;
	}

	public boolean deleteCattle(int cattleId, EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Cattle bk = entityManager.find(Cattle.class, cattleId);
		entityManager.remove(bk);
		entityTransaction.commit();
		log.info("Cattle Deleted Successfully");
		entityManager.close();
		return true;
	}

	public boolean updateCattle(Cattle cattle, EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(cattle);
		entityTransaction.commit();
		log.info("Cattle Updated Successfully");
		entityManager.close();
		return true;
	}

	public List<Cattle> getCattleList(EntityManager entityManager) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		TypedQuery<Cattle> cattleQuery = entityManager.createQuery("From Cattle", Cattle.class);
		List<Cattle> cattleList = cattleQuery.getResultList();
		entityTransaction.commit();
		entityManager.close();
		return cattleList;
	}

}
