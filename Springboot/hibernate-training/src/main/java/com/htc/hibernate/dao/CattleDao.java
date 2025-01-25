package com.htc.hibernate.dao;

import java.util.List;

import com.htc.hibernate.entity.Cattle;

public interface CattleDao {public boolean addCattle(Cattle cattle);
public Cattle getCattle(int cattleId);
public boolean deleteCattle(Cattle cattle);
public boolean updateCattle(Cattle cattle);
public List<Cattle> getCattleList();
}
