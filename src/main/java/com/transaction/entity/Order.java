package com.transaction.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ordertrakingNumber;
	private int totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	
	//The below annoation will automatically populate the value for this filed.
	@CreationTimestamp
	private LocalDateTime dateCreated;
	//The below annoation will automatically populate the value for this filed.
    @UpdateTimestamp
	private LocalDateTime lastUpdated;
	private Long shoppingCartId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrdertrakingNumber() {
		return ordertrakingNumber;
	}
	public void setOrdertrakingNumber(String ordertrakingNumber) {
		this.ordertrakingNumber = ordertrakingNumber;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Long getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Long shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	public Order(Long id, String ordertrakingNumber, int totalQuantity, BigDecimal totalPrice, String status,
			LocalDateTime dateCreated, LocalDateTime lastUpdated, Long shoppingCartId) {
		super();
		this.id = id;
		this.ordertrakingNumber = ordertrakingNumber;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.status = status;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
		this.shoppingCartId = shoppingCartId;
	}
	public Order() {
		
	}


}
