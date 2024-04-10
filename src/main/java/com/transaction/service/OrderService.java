package com.transaction.service;

import com.transaction.dto.OrderRequest;
import com.transaction.dto.OrderResponse;


public interface OrderService {

	//The below method is used to place the order.
	OrderResponse placeOrder(OrderRequest orderRequest);
	
}
