package com.material.management.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.material.management.dto.ProductMasterDto;
import com.material.management.entity.ProductMaster;
@Component
public class ProductMasterConvertor {
	@Autowired
	CategoryConvertor categoryConvertor;
	@Autowired
	TypeConvertor typeConvertor;
	@Autowired
	VolumeConvertor volumeConvertor;
	
	public ProductMaster dtoToEntity(ProductMasterDto productDto) {
		ProductMaster product=new ProductMaster();
		BeanUtils.copyProperties(productDto, product);
		if(productDto.getCategory()!=null) {
			product.getCategory().setCategoryId(productDto.getCategory().getCategoryId());
			product.getCategory().setCategoryName(productDto.getCategory().getCategoryName());
		}
		if(productDto.getType()!=null) {
			product.getType().setTypeId(productDto.getType().getTypeId());
			product.getType().setTypeName(productDto.getType().getTypeName());
		}
		if(productDto.getVolume()!=null) {
			product.getVolume().setVolumeId(productDto.getVolume().getVolumeId());
			product.getVolume().setVolumeMeterics(productDto.getVolume().getVolumeMeterics());
		}
		return product;
		
	}
	
	public ProductMasterDto entityToDto(ProductMaster product) {
		ProductMasterDto productDto=new ProductMasterDto();
		BeanUtils.copyProperties(product, productDto);
		
		if(product.getCategory()!=null) {
			productDto.getCategory().setCategoryId(product.getCategory().getCategoryId());
			productDto.getCategory().setCategoryName(product.getCategory().getCategoryName());
		}
		if(product.getType()!=null) {
			productDto.getType().setTypeId(product.getType().getTypeId());
			productDto.getType().setTypeName(product.getType().getTypeName());
		}
		if(product.getVolume()!=null) {
			productDto.getVolume().setVolumeId(product.getVolume().getVolumeId());
			productDto.getVolume().setVolumeMeterics(product.getVolume().getVolumeMeterics());
		}
		return productDto;
	}
}