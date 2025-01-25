package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.CattleTreatmentRepository;
import com.htc.spring.entity.relation.entity.CattleTreatment;

@Service("cattleTreatmentService")
public class CattleTreatmentService {
	@Autowired
	CattleTreatmentRepository cattleTreatmentRepository;

	public CattleTreatment addCattleTreatment(CattleTreatment cattleTreatment) {
		return cattleTreatmentRepository.save(cattleTreatment);
	}

	public void deleteCattleTreatment(int TreatmentId) {
		cattleTreatmentRepository.deleteById(TreatmentId);
	}

	public CattleTreatment getCattleTreatmentById(int TreatmentId) {
		Optional<CattleTreatment> cattleTreatment = cattleTreatmentRepository.findById(TreatmentId);
		if (cattleTreatment.isPresent())
			return cattleTreatment.get();
		else
			return null;
	}

	public List<CattleTreatment> getAllCattleTreatment() {
		return (List<CattleTreatment>) cattleTreatmentRepository.findAll();
	}

	public int updateCattleTreatment(CattleTreatment cattleTreatment) {
		CattleTreatment cattleTreatmentModel = cattleTreatmentRepository.save(cattleTreatment);
		return cattleTreatmentModel.getTreatmentId();
	}
}
