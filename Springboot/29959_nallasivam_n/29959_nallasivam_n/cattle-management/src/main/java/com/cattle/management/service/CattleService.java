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

import com.cattle.management.converter.CattleConverter;
import com.cattle.management.dto.CattleDTO;
import com.cattle.management.entity.Cattle;
import com.cattle.management.entity.Cattle;
import com.cattle.management.exception.TaskException;
import com.cattle.management.repository.CattleRepository;
import com.cattle.management.repository.CattleRepository;

@Service("cattleService")
public class CattleService {
	@Autowired
	CattleRepository cattleRepository;

	@Autowired
	CattleConverter cattleConverter;

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public CattleDTO addCattle(CattleDTO cattleDto) throws TaskException {
		if (Objects.nonNull(cattleDto)) {
			Cattle cattle = cattleConverter.dtoToEntity(cattleDto);
			if (Objects.nonNull(cattle))
				return cattleConverter.entityToDto(cattleRepository.save(cattle));
			else
				throw new TaskException("Cattle Data couldn't be inserted", HttpStatus.BAD_REQUEST);
		} else {
			throw new TaskException("Cattle Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public boolean deleteCattle(int cattleId) throws TaskException {
		Optional<Cattle> cattleOptional = cattleRepository.findById(cattleId);
		if (cattleOptional.isPresent()) {
			cattleRepository.deleteById(cattleId);
			return true;
		} else {
			throw new TaskException("Cattle Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public CattleDTO getCattleById(int cattleId) throws TaskException {
		Optional<Cattle> cattleOptional = cattleRepository.findById(cattleId);
		if (cattleOptional.isPresent())
			return cattleConverter.entityToDto(cattleOptional.get());
		else {
			throw new TaskException("Cattle Data not valid", HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public Set<CattleDTO> getAllCattle() throws TaskException {
		List<Cattle> cattleList = (List<Cattle>) cattleRepository.findAll();
		if (!CollectionUtils.isEmpty(cattleList)) {
			return cattleList.stream().map(cattle -> cattleConverter.entityToDto(cattle)).collect(Collectors.toSet());
		} else {
			throw new TaskException("Cattle Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}

	public CattleDTO updateCattle(CattleDTO cattleDTO) throws TaskException {
		if (Objects.nonNull(cattleDTO)) {
			Optional<Cattle> cattleOptional = cattleRepository.findById(cattleDTO.getCattleId());
			if (cattleOptional.isPresent())
				return cattleConverter.entityToDto(cattleRepository.save(cattleConverter.dtoToEntity(cattleDTO)));
			else {
				throw new TaskException("Cattle Data not Updated", HttpStatus.BAD_REQUEST);
			}
		} else {
			throw new TaskException("Cattle Infirmation not Found", HttpStatus.NOT_FOUND);
		}
	}
}