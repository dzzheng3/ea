package edu.mum.onlineshoping.service;

import java.util.List;

import edu.mum.onlineshoping.model.OrderDetails;

public interface OrderDetailsService {

	public void addOrderDetails(OrderDetails orderDetails);
	public List<OrderDetails> getAllOrderDetails();
	public OrderDetails getOrderDetailsById(Long id);
	public void removeOrderDetails(Long id);
	
	public OrderDetails findByProductId(long id);
}
