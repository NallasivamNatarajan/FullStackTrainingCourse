package com.material.management.dto;

import java.util.List;

import com.material.management.entity.Category;
import com.material.management.entity.LineNumbers;
import com.material.management.entity.Type;
import com.material.management.entity.Volume;

import lombok.Data;

@Data
public class PlaceOrderCategoryDto {
	
	private List<String> categories;
	private List<String> lineNumbers;
	private List<Category> categoryList;
	private List<Type> typeList;
	private List<Volume> volumeList;
	private List<LineNumbers> lineNumberList;

}
