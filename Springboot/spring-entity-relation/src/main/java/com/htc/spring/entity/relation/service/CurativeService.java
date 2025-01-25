package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.CurativeRepository;
import com.htc.spring.entity.relation.entity.Curative;

@Service("curativeService")
public class CurativeService {
	@Autowired
	CurativeRepository curativeRepository;

	public Curative addCurative(Curative curative) {
		return curativeRepository.save(curative);
	}

	public void deleteCurative(int curativeId) {
		curativeRepository.deleteById(curativeId);
	}

	public Curative getCurativeById(int curativeId) {
		Optional<Curative> curative = curativeRepository.findById(curativeId);
		if (curative.isPresent())
			return curative.get();
		else
			return null;
	}

	public List<Curative> getAllCurative() {
		return (List<Curative>) curativeRepository.findAll();
	}

	public int updateCurative(Curative curative) {
		Curative curativeModel = curativeRepository.save(curative);
		return curativeModel.getCurativeId();
	}
}
