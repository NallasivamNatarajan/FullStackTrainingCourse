package com.material.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.material.management.entity.ProductInventory;
@Repository
public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
	@Query(value = "SELECT line_number FROM product_inventory WHERE product_id = ?", nativeQuery = true)
    public String findLineNumberByProductId(long productid);
	
	@Query(value = "SELECT quantity FROM product_inventory WHERE product_id = ?", nativeQuery = true)
    public int findQuantityByProductId(long productid);
}
