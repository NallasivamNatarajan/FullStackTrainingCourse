package com.material.management.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.material.management.convertor.CartDetailsConverter;
import com.material.management.convertor.OrderDetailsConverter;
import com.material.management.convertor.UserConverter;
import com.material.management.dto.CartDetailsDto;
import com.material.management.dto.OrderCountsDto;
import com.material.management.dto.OrderDetailsDto;
import com.material.management.dto.OrderSummaryDetailsDto;
import com.material.management.entity.CartDetails;
import com.material.management.entity.OrderDetails;
import com.material.management.entity.OrderStatus;
import com.material.management.entity.ProductMaster;
import com.material.management.entity.User;
import com.material.management.exception.NotFoundException;
import com.material.management.repository.CartDetailsRepository;
import com.material.management.repository.DepartmentRepository;
import com.material.management.repository.OrderDetailsRepository;
import com.material.management.repository.OrderStatusRepository;
import com.material.management.repository.ProductNewRepository;
import com.material.management.repository.UserRepository;
import com.material.management.util.UtilsMethods;

@Service
public class MyOrdersService {

	static Logger log = LogManager.getLogger(MyOrdersService.class);

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CartDetailsRepository cartDetailsRepository;

	@Autowired
	UserConverter userConverter;

	@Autowired
	OrderDetailsConverter orderDetailsConverter;
	
	@Autowired
	CartDetailsConverter cartDetailsConverter;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	OrderStatusRepository orderStatusRepository;
	
	@Autowired
	ProductNewRepository productNewRepository;
	
	@Autowired
	UtilsMethods utils;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public OrderSummaryDetailsDto getOrderDetails(Long orderId) {
		OrderSummaryDetailsDto orderSummaryDetailsDto = new OrderSummaryDetailsDto();
//		OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
//		UserDto userData = new UserDto();
		if (orderId != null) {
			OrderDetails optOrderDetails = orderDetailsRepository.findById(orderId).orElse(new OrderDetails());
			
			if (Objects.nonNull(optOrderDetails)) {
				User optUserDetails = userRepository.findById(optOrderDetails.getUserId()).orElse(new User());
//				orderDetailsDto = orderDetailsConverter.entityToDto(optOrderDetails);
//				userData = userConverter.entityToDto(optUserDetails);
				orderSummaryDetailsDto.setDepartmentName(departmentRepository.findById(optUserDetails.getDepartmentId()).get().getDepartmentName());
				orderSummaryDetailsDto.setOrderRequestedDate(optOrderDetails.getOrderRequestedDate());
				orderSummaryDetailsDto.setLineNumber(optOrderDetails.getLineNumber());
				orderSummaryDetailsDto.setRequestSection(optOrderDetails.getRequestSection());
				orderSummaryDetailsDto.setOrderType(optOrderDetails.getOrderType());
				orderSummaryDetailsDto.setUserName(optUserDetails.getUserName());
				orderSummaryDetailsDto.setOrderNumber(optOrderDetails.getOrderNumber());
				orderSummaryDetailsDto.setUserId(optUserDetails.getUserId());
				orderSummaryDetailsDto.setOrderId(optOrderDetails.getOrderId());
				orderSummaryDetailsDto.setCartData(cartSummaryDetails(optOrderDetails.getOrderId()));
				orderSummaryDetailsDto.setAdminComments(optOrderDetails.getAdminComments());
				orderSummaryDetailsDto.setShiftInchargeComments(optOrderDetails.getShiftInchargeComments());
				orderSummaryDetailsDto.setOrderStatus(orderStatusRepository.findOrderStatusNameByOrderStatusId(optOrderDetails.getOrderStatusId()));
				log.info("OrderDetails Retrieved Successfully");
				return orderSummaryDetailsDto;
			} else {
				log.info("OrderDetails Data does not exist");
				throw new NotFoundException("OrderDetails Data does not exist", HttpStatus.NOT_FOUND);
			}
		} else {
			log.info("Not a Valid  OrderId");
			throw new NotFoundException("Not a Valid  OrderId", HttpStatus.BAD_REQUEST);
		}

	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public List<OrderDetailsDto> getAllOrderDetails() {
		List<OrderDetails> allOrders = (List<OrderDetails>) orderDetailsRepository.findAll();
		List<OrderDetailsDto> allOrderDetails = orderDetailsConverter.listOfEntityToDto(allOrders);
		allOrderDetails.forEach(orderDetail ->{
			Optional<User> optUserDetails = userRepository.findById(orderDetail.getUserId());
			Optional<OrderStatus> optStatus= orderStatusRepository.findById(orderDetail.getOrderStatusId());
			orderDetail.setRequestedDepartment(departmentRepository.findById(optUserDetails.get().getDepartmentId()).get().getDepartmentName());
			orderDetail.setOrderStatus(optStatus.get().getOrderStatusName());
		});
		return allOrderDetails;
	}

	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public OrderSummaryDetailsDto addCartDetails(Long userId, List<CartDetailsDto> cartDetails) {
		OrderSummaryDetailsDto orderSummaryDetailsDto = new OrderSummaryDetailsDto();
		OrderDetails orderDetails = new OrderDetails();
		List<CartDetails> cartData = new ArrayList<>();
		Optional<User> optUserDetails = userRepository.findById(userId);
		orderDetails.setOrderId(orderDetailsRepository.getLatestOrderId() + 1);
		orderDetails.setCreatedBy(optUserDetails.get().getUserName());
		orderDetails.setCreatedDate(new Date());
		orderDetails.setLastUpdatedBy(optUserDetails.get().getUserName());
		orderDetails.setLastUpdatedDate(new Date());
		orderDetails.setLineNumber(cartDetails.get(0).getLineNumber());
		orderDetails.setOrderNumber(utils.generateNewOrderNumber());
		orderDetails.setOrderRequestedDate(new Date());
		orderDetails.setOrderStatusId(1);
		orderDetails.setOrderType("Regular");
		orderDetails.setRequestSection("Process-interior");
		orderDetails.setUserId(userId);
		orderDetailsRepository.save(orderDetails);
		User userDetails =userRepository.findUserByUserId(userId);
		cartData = cartDetailsConverter.listOfDtoToEntity(cartDetails);
		cartData.forEach(data -> {
			data.setCartStatus("Active");
			data.setCreatedBy(userDetails.getUserName());
			data.setCreatedDate(new Date());
			data.setLastUpdatedDate(new Date());
			data.setLastUpdatedBy(userDetails.getUserName());
			data.setOrderId(orderDetails.getOrderId());
		});
		cartDetailsRepository.saveAll(cartData);
		
		orderSummaryDetailsDto.setDepartmentName(departmentRepository.findById(userDetails.getDepartmentId()).get().getDepartmentName());
		orderSummaryDetailsDto.setOrderRequestedDate(orderDetails.getOrderRequestedDate());
		orderSummaryDetailsDto.setLineNumber(orderDetails.getLineNumber());
		orderSummaryDetailsDto.setRequestSection(orderDetails.getRequestSection());
		orderSummaryDetailsDto.setOrderType(orderDetails.getOrderType());
		orderSummaryDetailsDto.setUserName(userDetails.getUserName());
		orderSummaryDetailsDto.setOrderNumber(orderDetails.getOrderNumber());
		orderSummaryDetailsDto.setUserId(userDetails.getUserId());
		orderSummaryDetailsDto.setOrderId(orderDetails.getOrderId());
		
		orderSummaryDetailsDto.setCartData(cartSummaryDetails(orderDetails.getOrderId()));
		
		return orderSummaryDetailsDto;
	} 
	
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public List<CartDetailsDto> cartSummaryDetails(long orderId){
		List<CartDetailsDto> cartDetailDto= new ArrayList<>();
		
		List<CartDetails> cartDetails= cartDetailsRepository.findCartDataByOrderId(orderId);
		cartDetailDto = cartDetailsConverter.listOfEntityToDto(cartDetails);
		cartDetailDto.forEach(cartData->{
			ProductMaster prdMasterData = productNewRepository.findProductByProductId(cartData.getProductId());
			cartData.setProductName(prdMasterData.getProductName());
			cartData.setCategory(prdMasterData.getCategory());
			cartData.setDiameter(prdMasterData.getDiameter());
			cartData.setDriveSize(prdMasterData.getDriveSize());
			cartData.setLength(prdMasterData.getLength());
			cartData.setType(prdMasterData.getType());
		});
		return cartDetailDto;
		
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public String updateOrderDetails(Long orderId, Long orderStatusId,String comments) {
		OrderDetails order = orderDetailsRepository.findOrderDetailByOrderId(orderId);
		 if(Objects.nonNull(order)) {
			 order.setOrderStatusId(orderStatusId);
			 if(orderStatusId == 2 || orderStatusId==3) {
			 order.setShiftInchargeComments(comments);
			 }else if(orderStatusId==4 || orderStatusId==5) {
				 order.setAdminComments(comments); 
			 }else {
				 order.setShiftInchargeComments(null);
				 order.setAdminComments(null); 
			 }
			 orderDetailsRepository.save(order);
		 }else {
			throw new NotFoundException("Order Data Not found",HttpStatus.NOT_FOUND);
		 }
		return "Order Data Updated Successfully";
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public String deleteOrderData(Long orderId) {
		if(orderId != null) {
			orderDetailsRepository.deleteById(orderId);
			cartDetailsRepository.deleteByOrderId(orderId);
			log.info("Order Data Deleted Successfully");
		}else {
			throw new NotFoundException("Invalid Order Id",HttpStatus.BAD_REQUEST);
		}
		return "Order Data Deleted Successfully";
	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = java.lang.Exception.class)
	public OrderCountsDto getOrdersCount() {
		OrderCountsDto res = new OrderCountsDto();
		List<OrderDetails> allOrders = (List<OrderDetails>) orderDetailsRepository.findAll();
		Map<Long, Long> map = allOrders.stream()
				.collect(Collectors.groupingBy(OrderDetails::getOrderStatusId, Collectors.counting()));
		
		map.forEach((k, v) -> {
			if (k.intValue() == 1 || k.intValue() == 2) {
				res.setPendingCount(v.intValue());
			}
			if (k.intValue() == 3 || k.intValue() == 4) {
				res.setRejectedCount(v.intValue());
			}
			if (k.intValue() == 5) {
				res.setApprovedCount(v.intValue());
			}
		});
		res.setTotalCount(res.getApprovedCount() + res.getPendingCount() + res.getRejectedCount());
		return res;
	}

	
}
