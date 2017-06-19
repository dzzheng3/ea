package edu.mum.onlineshoping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.onlineshoping.model.OrderDetails;
import edu.mum.onlineshoping.repository.OrderDetailsRepository;
import edu.mum.onlineshoping.service.OrderDetailsService;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService{

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public void addOrderDetails(OrderDetails orderDetails) {
		orderDetailsRepository.save(orderDetails);
		
	}

	public List<OrderDetails> getAllOrderDetails() {
		 
		return (List<OrderDetails>) orderDetailsRepository.findAll();
	}

	public OrderDetails getOrderDetailsById(Long id) {
		 
		return orderDetailsRepository.findOne(id);
	}

	public void removeOrderDetails(Long id) {
		orderDetailsRepository.delete(id);
		
	}

	public OrderDetails findByProductId(long id) {
		 
		return orderDetailsRepository.findByProductId(id);
	}

}
