package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.CattleHouseRepository;
import com.htc.spring.entity.relation.entity.CattleHouse;

@Service("cattleHouseService")
public class CattleHouseService {
	@Autowired
	CattleHouseRepository cattleHouseRepository;

	public CattleHouse addCattleHouse(CattleHouse cattleHouse) {
		return cattleHouseRepository.save(cattleHouse);
	}

	public void deleteCattleHouse(int cattleId) {
		cattleHouseRepository.deleteById(cattleId);
	}

	public CattleHouse getCattleHouseById(int cattleHouseId) {
		Optional<CattleHouse> cattleHouse = cattleHouseRepository.findById(cattleHouseId);
		if (cattleHouse.isPresent())
			return cattleHouse.get();
		else
			return null;
	}

	public List<CattleHouse> getAllCattleHouse() {
		return (List<CattleHouse>) cattleHouseRepository.findAll();
	}

	public int updateCattleHouse(CattleHouse cattle) {
		CattleHouse cattleHouse = cattleHouseRepository.save(cattle);
		return cattleHouse.getCattleHouseId();
	}
}