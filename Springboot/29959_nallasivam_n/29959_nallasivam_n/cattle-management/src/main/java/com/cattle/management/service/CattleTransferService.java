package com.cattle.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.cattle.management.converter.CattleTransferConverter;
import com.cattle.management.dto.CattleTransferDTO;
import com.cattle.management.entity.CattleTransfer;
import com.cattle.management.exception.TaskException;
import com.cattle.management.repository.CattleTransferRepository;

@Service("cattleTransferService")
public class CattleTransferService {
	@Autowired
	CattleTransferRepository cattleTransferRepository;

	@Autowired
	CattleTransferConverter cattleTransferConverter;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public CattleTransferDTO addCattleTransfer(CattleTransferDTO cattleTransferDto) throws TaskException {
		if (Objects.nonNull(cattleTransferDto)) {
			CattleTransfer cattleTransfer = cattleTransferConverter.dtoToEntity(cattleTransferDto);
			if (Objects.nonNull(cattleTransfer))
				return cattleTransferConverter.entityToDto(cattleTransferRepository.save(cattleTransfer));
			else
				throw new TaskException("CattleTransfer Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("CattleTransfer Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteCattleTransfer(int cattleTransferId) throws TaskException {
		Optional<CattleTransfer> cattleTransferOptional = cattleTransferRepository.findById(cattleTransferId);
		if (cattleTransferOptional.isPresent()) {
			cattleTransferRepository.deleteById(cattleTransferId);
			return true;
		} else {
			throw new TaskException("CattleTransfer Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public CattleTransferDTO getCattleTransferById(int cattleTransferId) throws TaskException {
		Optional<CattleTransfer> cattleTransferOptional = cattleTransferRepository.findById(cattleTransferId);
		if (cattleTransferOptional.isPresent())
			return cattleTransferConverter.entityToDto(cattleTransferOptional.get());
		else {
			throw new TaskException("CattleTransfer Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<CattleTransferDTO> getAllCattleTransfer() throws TaskException {
		List<CattleTransfer> cattleTransferList = (List<CattleTransfer>) cattleTransferRepository.findAll();
		if (!CollectionUtils.isEmpty(cattleTransferList)) {
			return cattleTransferList.stream().map(cattleTransfer -> cattleTransferConverter.entityToDto(cattleTransfer)).collect(Collectors.toSet());
		} else {
			throw new TaskException("CattleTransfer Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	public CattleTransferDTO updateCattleTransfer(CattleTransferDTO cattleTransferDTO) throws TaskException {
		if (Objects.nonNull(cattleTransferDTO)) {
			Optional<CattleTransfer> cattleTransferOptional = cattleTransferRepository.findById(cattleTransferDTO.getTransferId());
			if (cattleTransferOptional.isPresent())
				return cattleTransferConverter.entityToDto(cattleTransferRepository.save(cattleTransferConverter.dtoToEntity(cattleTransferDTO)));
			else {
				throw new TaskException("CattleTransfer Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("CattleTransfer Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}