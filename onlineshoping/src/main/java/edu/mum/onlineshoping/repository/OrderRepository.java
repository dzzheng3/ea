package edu.mum.onlineshoping.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.onlineshoping.domain.Order;
import edu.mum.onlineshoping.domain.Person;
import edu.mum.onlineshoping.domain.Product;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findDistinctOrderByOrderLines_Product(Product product);
	List<Order> findOrderByPerson(Person person);
	List<Order> findOrderByOrderDateBetween(Date minDate, Date maxDate);
	

}
