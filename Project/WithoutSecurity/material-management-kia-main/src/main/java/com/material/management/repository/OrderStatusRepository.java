package com.material.management.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.material.management.entity.OrderStatus;
@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {

	@Query(value="select order_status_name from order_status where order_status_id=:orderStatusId",nativeQuery=true)
	public String findOrderStatusNameByOrderStatusId(long orderStatusId);

}
