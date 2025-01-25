package com.material.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.CartDetails;

@Repository
public interface CartDetailsRepository extends CrudRepository<CartDetails, Long>{

	@Query(value="Select * from cart_details where cart_id=:cartId", nativeQuery=true)
	Optional<List<CartDetails>> findCartDetailsById(long cartId);

	@Query(value="Select * from cart_details where order_id=:orderId", nativeQuery=true)
	List<CartDetails> findCartDataByOrderId(long orderId);

	void deleteByOrderId(Long orderId);

}
