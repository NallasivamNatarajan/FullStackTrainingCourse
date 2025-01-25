package com.material.management.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.CategoryDto;
import com.material.management.entity.Category;
@Component
public class CategoryConvertor {
	public Category dtoToEntity(CategoryDto categoryDto) {
		Category category=new Category();
		BeanUtils.copyProperties(categoryDto, category);		
		return category;
	}
	
	public CategoryDto entityToDto(Category category) {
		CategoryDto categoryDto=new CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);
		return categoryDto;
		
	}

}
