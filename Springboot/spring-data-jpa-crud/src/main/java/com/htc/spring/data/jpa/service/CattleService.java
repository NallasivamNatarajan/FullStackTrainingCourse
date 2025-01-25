package com.htc.spring.data.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.data.jpa.dao.CattleRepository;
import com.htc.spring.data.jpa.entity.Cattle;

@Service("cattleService")
public class CattleService {
	@Autowired
	CattleRepository cattleRepository;

	public Cattle addCattle(Cattle cattle) {
		return cattleRepository.save(cattle);
	}

	public void deleteCattle(int cattleId) {
		cattleRepository.deleteById(cattleId);
	}

	public Cattle getCattleById(int cattleId) {
		Optional<Cattle> cattle = cattleRepository.findById(cattleId);
		if (cattle.isPresent())
			return cattle.get();
		else
			return null;
	}

	public List<Cattle> getAllCattle() {
		return (List<Cattle>) cattleRepository.findAll();
	}

	public int updateCattle(Cattle cattle) {
		Cattle cattleModel = cattleRepository.save(cattle);
		return cattleModel.getCattleId();
	}
}
