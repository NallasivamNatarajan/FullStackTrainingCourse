package com.material.management.convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.material.management.dto.CartDetailsDto;
import com.material.management.entity.CartDetails;
@Component
public class CartDetailsConverter {
	public CartDetails dtoToEntity(CartDetailsDto cartDetailsDto) {
		CartDetails cartDetails = new CartDetails();
		BeanUtils.copyProperties(cartDetailsDto, cartDetails);
		return cartDetails;
	}

	public CartDetailsDto entityToDto(CartDetails cartDetails) {
		CartDetailsDto cartDetailsDto = new CartDetailsDto();
		BeanUtils.copyProperties(cartDetails, cartDetailsDto);
		return cartDetailsDto;

	}
	
	public List<CartDetails> listOfDtoToEntity(List<CartDetailsDto> cartDetailsDto){
		return cartDetailsDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<CartDetailsDto> listOfEntityToDto(List<CartDetails> cartDetails){
		return cartDetails.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}

}
