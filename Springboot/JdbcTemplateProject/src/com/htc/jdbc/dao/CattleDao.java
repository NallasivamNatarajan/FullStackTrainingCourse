package com.htc.jdbc.dao;

import java.util.List;

import com.htc.jdbc.entity.Cattle;


public interface CattleDao {
	public boolean addCattle(Cattle cattle);
	public Cattle getCattle(int cattleId);
	public boolean deleteCattle(int cattleId);
	public boolean updateCattle(Cattle cattle);
	public List<Cattle> getCattleList();

}
