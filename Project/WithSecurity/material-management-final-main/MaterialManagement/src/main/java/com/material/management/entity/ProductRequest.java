package com.material.management.entity;

import java.util.List;

public class ProductRequest {
	
	private List<Category> categoryList;

	private List<Type> typeList;
	
	private List<Volume> volumeList;
	
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}

	public List<Type> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<Type> typeList) {
		this.typeList = typeList;
	}

	public List<Volume> getVolumeList() {
		return volumeList;
	}

	public void setVolumeList(List<Volume> volumeList) {
		this.volumeList = volumeList;
	}


}
