package com.htc.spring.entity.relation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.spring.entity.relation.dao.CattleTransferRepository;
import com.htc.spring.entity.relation.entity.CattleTransfer;

@Service("cattleTransferService")
public class CattleTransferService {
	@Autowired
	CattleTransferRepository cattleTransferRepository;

	public CattleTransfer addCattleTransfer(CattleTransfer cattleTransfer) {
		return cattleTransferRepository.save(cattleTransfer);
	}

	public void deleteCattleTransfer(int transferId) {
		cattleTransferRepository.deleteById(transferId);
	}

	public CattleTransfer getCattleTransferById(int transferId) {
		Optional<CattleTransfer> cattleTransfer = cattleTransferRepository.findById(transferId);
		if (cattleTransfer.isPresent())
			return cattleTransfer.get();
		else
			return null;
	}

	public List<CattleTransfer> getAllCattleTransfer() {
		return (List<CattleTransfer>) cattleTransferRepository.findAll();
	}

	public int updateCattleTransfer(CattleTransfer cattleTransfer) {
		CattleTransfer cattleTransferModel = cattleTransferRepository.save(cattleTransfer);
		return cattleTransferModel.getTransferId();
	}
}
