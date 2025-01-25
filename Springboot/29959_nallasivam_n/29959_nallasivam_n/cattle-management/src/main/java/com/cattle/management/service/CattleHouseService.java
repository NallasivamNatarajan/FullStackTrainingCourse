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

import com.cattle.management.converter.CattleHouseConverter;
import com.cattle.management.dto.CattleHouseDTO;
import com.cattle.management.entity.CattleHouse;
import com.cattle.management.exception.TaskException;
import com.cattle.management.repository.CattleHouseRepository;

@Service("cattleHouseService")
public class CattleHouseService {
	@Autowired
	CattleHouseRepository cattleHouseRepository;

	@Autowired
	CattleHouseConverter cattleHouseConverter;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public CattleHouseDTO addCattleHouse(CattleHouseDTO cattleHouseDto) throws TaskException {
		if (Objects.nonNull(cattleHouseDto)) {
			CattleHouse cattleHouse = cattleHouseConverter.dtoToEntity(cattleHouseDto);
			if (Objects.nonNull(cattleHouse))
				return cattleHouseConverter.entityToDto(cattleHouseRepository.save(cattleHouse));
			else
				throw new TaskException("CattleHouse Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("CattleHouse Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteCattleHouse(int cattleHouseId) throws TaskException {
		Optional<CattleHouse> cattleHouseOptional = cattleHouseRepository.findById(cattleHouseId);
		if (cattleHouseOptional.isPresent()) {
			cattleHouseRepository.deleteById(cattleHouseId);
			return true;
		} else {
			throw new TaskException("CattleHouse Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public CattleHouseDTO getCattleHouseById(int cattleHouseId) throws TaskException {
		Optional<CattleHouse> cattleHouseOptional = cattleHouseRepository.findById(cattleHouseId);
		if (cattleHouseOptional.isPresent())
			return cattleHouseConverter.entityToDto(cattleHouseOptional.get());
		else {
			throw new TaskException("CattleHouse Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<CattleHouseDTO> getAllCattleHouse() throws TaskException {
		List<CattleHouse> cattleHouseList = (List<CattleHouse>) cattleHouseRepository.findAll();
		if (!CollectionUtils.isEmpty(cattleHouseList)) {
			return cattleHouseList.stream().map(cattleHouse -> cattleHouseConverter.entityToDto(cattleHouse)).collect(Collectors.toSet());
		} else {
			throw new TaskException("CattleHouse Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	public CattleHouseDTO updateCattleHouse(CattleHouseDTO cattleHouseDTO) throws TaskException {
		if (Objects.nonNull(cattleHouseDTO)) {
			Optional<CattleHouse> cattleHouseOptional = cattleHouseRepository.findById(cattleHouseDTO.getCattleHouseId());
			if (cattleHouseOptional.isPresent())
				return cattleHouseConverter.entityToDto(
						cattleHouseRepository.save(
								cattleHouseConverter.dtoToEntity(cattleHouseDTO)));
			else {
				throw new TaskException("CattleHouse Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("CattleHouse Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}