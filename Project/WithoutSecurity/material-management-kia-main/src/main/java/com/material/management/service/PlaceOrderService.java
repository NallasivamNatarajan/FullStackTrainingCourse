package com.material.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.material.management.dto.PlaceOrderCategoryDto;
import com.material.management.repository.CategoryNewRepository;
import com.material.management.repository.LineNumbersRepository;
import com.material.management.repository.TypeRepository;
import com.material.management.repository.VolumeRepository;

@Service
public class PlaceOrderService {

	@Autowired
	CategoryNewRepository categoryNewRepository;
	
	@Autowired
	LineNumbersRepository lineNumbersRepository;
	
	@Autowired
	TypeRepository typeRepository;
	
	@Autowired
	VolumeRepository volumeRepository;
	
	public PlaceOrderCategoryDto getDropDownListDto() {
		PlaceOrderCategoryDto placeOrderCategoryDto=new PlaceOrderCategoryDto();
		placeOrderCategoryDto.setCategories(categoryNewRepository.findAll().stream().map(i->i.getCategoryName()).toList());
		placeOrderCategoryDto.setLineNumbers(lineNumbersRepository.findAll().stream().map(i->i.getLineNumber()).toList());
		placeOrderCategoryDto.setCategoryList(categoryNewRepository.findAll(Sort.by("CategoryId")));
		placeOrderCategoryDto.setTypeList(typeRepository.findAll(Sort.by("TypeId")));
		placeOrderCategoryDto.setLineNumberList(lineNumbersRepository.findAll(Sort.by("Id")));
		placeOrderCategoryDto.setVolumeList(volumeRepository.findAll(Sort.by("VolumeId")));	
		return placeOrderCategoryDto;
	}
	
}
