package com.material.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.material.management.entity.ProductMaster;
@Repository
public interface ProductNewRepository extends JpaRepository<ProductMaster, Long> {
	
	@Query(value = "SELECT * FROM product_master WHERE product_name = ?", nativeQuery = true)
	Optional<ProductMaster> findByName(String name);

	ProductMaster findProductByProductId(long productId);
	
	@Query(value = "SELECT * FROM product_master WHERE product_name =:productName and category_id=:categoryId and type_id=:typeId", nativeQuery = true)
	Optional<ProductMaster> findProduct(String productName, long categoryId, long typeId);
 

}
