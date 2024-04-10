package com.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.dto.OrderRequest;
import com.transaction.dto.OrderResponse;
import com.transaction.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
	
	private OrderService orderService;

	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
		return ResponseEntity.ok(orderService.placeOrder(orderRequest));
	}
	
	

}
