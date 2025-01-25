package com.material.management.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.material.management.convertor.CategoryConvertor;
import com.material.management.entity.Category;
import com.material.management.entity.ProductRequest;
import com.material.management.entity.Type;
import com.material.management.entity.Volume;
import com.material.management.repository.CategoryNewRepository;
import com.material.management.repository.TypeRepository;
import com.material.management.repository.VolumeRepository;
@Service
public class CategoryNewService {

	static Logger log = LogManager.getLogger(CategoryNewService.class);

	@Autowired
	CategoryNewRepository categoryRepository;
	@Autowired
	TypeRepository typeRepository;
	@Autowired
	VolumeRepository volumeRepository;

	@Autowired
	CategoryConvertor categoryConvertor;
	
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public ProductRequest getAllDropdownValues()
	{
		List<Category> categoryList = (List<Category>) categoryRepository.findAll();
		List<Type> typeList = (List<Type>) typeRepository.findAll();
		List<Volume> volumeList = (List<Volume>) volumeRepository.findAll();
		ProductRequest productRequest= new ProductRequest();
		productRequest.setCategoryList(categoryList);
		productRequest.setTypeList(typeList);
		productRequest.setVolumeList(volumeList);
		return productRequest;
	}
}