package com.material.management.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.OrderDetailsDto;
import com.material.management.entity.OrderDetails;

@Component
public class OrderDetailsConverter {
	public OrderDetails dtoToEntity(OrderDetailsDto orderDetailsDto) {
		OrderDetails orderDetails = new OrderDetails();
		BeanUtils.copyProperties(orderDetailsDto, orderDetails);
		return orderDetails;
	}

	public OrderDetailsDto entityToDto(OrderDetails optOrderDetails) {
		OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
		BeanUtils.copyProperties(optOrderDetails, orderDetailsDto);
		return orderDetailsDto;

	}
	
	public List<OrderDetails> listOfDtoToEntity(List<OrderDetailsDto> orderDetailsDto){
		return orderDetailsDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<OrderDetailsDto> listOfEntityToDto(List<OrderDetails> optOrderDetails){
		return optOrderDetails.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}
	
}