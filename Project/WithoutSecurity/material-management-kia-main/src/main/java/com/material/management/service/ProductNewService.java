package com.material.management.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.material.management.convertor.ProductInventoryConvertor;
import com.material.management.convertor.ProductMasterConvertor;
import com.material.management.dto.ProductMasterDto;
import com.material.management.entity.ProductInventory;
import com.material.management.entity.ProductMaster;
import com.material.management.exception.AlreadyExistsException;
import com.material.management.repository.CategoryNewRepository;
import com.material.management.repository.ProductInventoryRepository;
import com.material.management.repository.ProductNewRepository;
import com.material.management.repository.TypeRepository;
import com.material.management.repository.VolumeRepository;
import com.material.management.util.UtilsMethods;

@Service
public class ProductNewService {

	static Logger log = LogManager.getLogger(ProductNewService.class);
	@Autowired
	CategoryNewRepository categoryNewRepository;

	@Autowired
	TypeRepository typeRepository;

	@Autowired
	VolumeRepository volumeRepository;

	@Autowired
	ProductNewRepository productNewRepository;

	@Autowired
	ProductMasterConvertor productsConvertor;

	@Autowired
	ProductInventoryRepository productInventoryRepository;

	@Autowired
	ProductInventoryConvertor productInventoryConvertor;
	

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
    public List<ProductMasterDto> getAllProducts() {
        List<ProductMaster> productList = (List<ProductMaster>) productNewRepository.findAll();
        
        List<ProductMasterDto> dtobranchList = productList.stream()
                .map(product -> productsConvertor.entityToDto(product)).toList();
        dtobranchList.stream().forEach(prod -> {
            prod.setLineNumber(productInventoryRepository.findLineNumberByProductId(prod.getProductId()));
        });
        dtobranchList.stream().forEach(prod -> {
        	int prdId =productInventoryRepository.findQuantityByProductId(prod.getProductId());
        	if (Objects.nonNull(prdId)) {
        		prod.setQuantity(prdId);
        	}
           // prod.setQuantity((prdId != null) ? productInventoryRepository.findQuantityByProductId(prod.getProductId()):0);
        });
        return dtobranchList;
    }
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public ProductMasterDto getProductById(long productId) {
		Optional<ProductMaster> productMasterOptional = productNewRepository.findById(productId);
		if(productMasterOptional.isPresent()) {
			return productsConvertor.entityToDto(productMasterOptional.get());
		}
		return null;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public ProductMasterDto addProduct(ProductMasterDto productsDto) {

		ProductMaster products = productsConvertor.dtoToEntity(productsDto);
		
		Optional<ProductMaster> productExisting = productNewRepository.findProduct(products.getProductName(),products.getCategory().getCategoryId(),products.getType().getTypeId());
		
		if(productExisting.isPresent()) {
            log.error("** productsExisting is true**");
            throw new AlreadyExistsException("Products is Already Existing : " + productExisting.get().getProductId());}
            else {
			products.setPartNumber(UtilsMethods.getStingRandomNumber("GTS"));
			products.setCreatedDate(new Date());
			products.setLastUpdatedBy(products.getCreatedBy());
			products.setLastUpdatedDate(new Date());
			if (productNewRepository.save(products) != null) {
				ProductInventory productInventory = new ProductInventory();
				productInventory.setLineNumber(productsDto.getLineNumber());
				productInventory.setQuantity(productsDto.getQuantity());
				productInventory.setProductId(products.getProductId());	
				productInventory.setCreatedDate(new Date());
				productInventory.setLastUpdatedDate(new Date());
				productInventory.setLastUpdatedBy(products.getCreatedBy());
				addProductInventory(productInventory);
				log.info("** Products saved SUCCESS**");
				ProductMasterDto productDto = productsConvertor.entityToDto(products);
				return productDto;
			} else {
				log.info("** Products saved FAILED**");
				throw new AlreadyExistsException("Products is not Saved.. Please check the logs");
			}

		}

	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public ProductInventory addProductInventory(ProductInventory productInventory) {
		if (productInventoryRepository.save(productInventory) != null) {
			log.info("** Product inventory saved SUCCESS**");
			return productInventory;
		} else {
			log.info("** Product inventory saved FAILED**");
			throw new AlreadyExistsException("Products inventory is not Saved.. Please check the logs");
		}
	}
}
