package com.htc.jdbc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.htc.jdbc.entity.Cattle;

public class CattleDaoImpl implements CattleDao{
	
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean addCattle(Cattle cattle) {
		int rowCount = jdbcTemplate.update("INSERT INTO tb_cattle "
				+ "VALUES(?,?,?,?,?,?,?,?,?)",
				cattle.getCattleId(),cattle.getBirthDay(),
				cattle.getBirthWeight(), cattle.getEntranceDate(),
				cattle.getOriginalArea(), cattle.getCattleHouseId(),
				cattle.isFlag(), cattle.getBreedAreaId(),
				cattle.getImmunityporty());
		if(rowCount>0) return true;
		return false;
	}

	@Override
	public Cattle getCattle(int cattleId) {
		Cattle cattle = jdbcTemplate.queryForObject("Select * from tb_cattle where cattle_id=?", 
				(resultSet, arg1) -> Cattle.fromDto(resultSet, arg1), 
				cattleId);
		return cattle;
	}

	@Override
	public boolean deleteCattle(int cattleId) {
		int rowCount = jdbcTemplate.update("DELETE FROM tb_cattle "
				+ "WHERE cattle_id=?", cattleId);
		if(rowCount>0) return true;
		return false;
	}

	@Override
	public boolean updateCattle(Cattle cattle) {
		NamedParameterJdbcTemplate namedTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("originalArea", cattle.getOriginalArea());
		paramMap.put("cattleId", cattle.getCattleId());
		int rowCount = namedTemplate.update("update tb_cattle set original_area=:originalArea where cattle_id=:cattleId",
				paramMap);
		if(rowCount>0) return true;
		return false;
	}

	@Override
	public List<Cattle> getCattleList() {
		List<Cattle> cattleList = jdbcTemplate.query("Select * from tb_cattle", 
				(resultSet, args) -> Cattle.fromDto(resultSet, args));
		return cattleList;
	}

}
