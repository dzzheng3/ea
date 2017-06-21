package edu.mum.onlineshoping.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.onlineshoping.model.ShoppingCart;


public interface ShoppingCartService {
	public ShoppingCart getById(Long Id);
	public List<ShoppingCart> getAll();
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_CUSTOMER')")
	public void saveShoppingCart(Long productId);
	public void deletShoppingCart(ShoppingCart shoppingCart);
	public ShoppingCart findByTotalPrice();
	public ShoppingCart findByOrderId(Long id);
	
	public void deletAllCart();
	public double findTotalCartCost(List<ShoppingCart> shoppingCarts);
}
