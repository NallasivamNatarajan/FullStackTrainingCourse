package com.htc.spring.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.htc.spring.jpa.entity.Cattle;

public interface CattleDao {
	public boolean addCattle(Cattle cattle, EntityManager entityManager);

	public Cattle getCattle(int cattleId, EntityManager entityManager);

	public boolean deleteCattle(int cattleId, EntityManager entityManager);

	public boolean updateCattle(Cattle cattle, EntityManager entityManager);

	public List<Cattle> getCattleList(EntityManager entityManager);
}
