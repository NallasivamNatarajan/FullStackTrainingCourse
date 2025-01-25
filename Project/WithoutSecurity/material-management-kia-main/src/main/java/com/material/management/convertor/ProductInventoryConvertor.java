package com.material.management.convertor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.ProductInventoryDto;
import com.material.management.entity.ProductInventory;
@Component
public class ProductInventoryConvertor {
	public ProductInventory dtoToEntity(ProductInventoryDto productInventoryDto) {
		ProductInventory productInventory=new ProductInventory();
		BeanUtils.copyProperties(productInventoryDto, productInventory);		
		return productInventory;
	}
	
	public ProductInventoryDto entityToDto(ProductInventory productInventory) {
		ProductInventoryDto productInventoryDto=new ProductInventoryDto();
		BeanUtils.copyProperties(productInventory, productInventoryDto);
		return productInventoryDto;
		
	}

}
