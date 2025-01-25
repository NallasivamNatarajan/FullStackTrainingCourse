package com.material.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.OrderDetails;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetails, Long> {
	
	@Query(value="select max(order_id) from order_details",nativeQuery=true)
	public int getLatestOrderId();

	public void save(Optional<OrderDetails> order);

	public OrderDetails findOrderDetailByOrderId(Long orderId);

}
