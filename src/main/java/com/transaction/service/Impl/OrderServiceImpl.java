package com.transaction.service.Impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.dto.OrderRequest;
import com.transaction.dto.OrderResponse;
import com.transaction.entity.Order;
import com.transaction.entity.Payment;
import com.transaction.exception.PaymentException;
import com.transaction.repository.OrderRepository;
import com.transaction.repository.PaymentRepository;
import com.transaction.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	
	private OrderRepository orderRepository;
	private PaymentRepository paymentRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
	}


	//The below method contains two operations.
	//If we add @Transcational annotation to this method, Then this method will execute in a single transaction
	//@Transcational annotation having the properties like eg: @Transcational(readOnly),
	//@Transcational(rollbackFor = PaymentException.class). Note: It is used for rollback particular exception
	
	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		
		
		Order order= orderRequest.getOrder();
		order.setStatus("IN-PROGRESS");
		
		order.setOrdertrakingNumber(UUID.randomUUID().toString());
		
		//Operation 1
		orderRepository.save(order);
		
		Payment payment= orderRequest.getPayment();
		
		//Here we are supporting the payment card type of debit only.
		if(!payment.getType().equals("DEBIT")) {
			throw new PaymentException("Payment card type is not supported");
		}
		
		payment.setOrderId(order.getId());
		
		//Operation 2
		paymentRepository.save(payment);
		
		OrderResponse orderResponse= new OrderResponse();
		orderResponse.setOrderTrackingNumber(order.getOrdertrakingNumber());
		orderResponse.setStatus(order.getStatus());
		orderResponse.setMessage("SUCCESS");
		
		
		return orderResponse;
	}

}
