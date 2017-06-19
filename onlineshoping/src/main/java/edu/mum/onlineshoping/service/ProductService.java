package edu.mum.onlineshoping.service;

import java.util.List;

import edu.mum.onlineshoping.model.Product;

public interface ProductService {
	public List <Product> getAll();
	public Product getProductById(Long key);
	public void delete(Long id);
	public void addProduct(Product product);	
	//public void updateProduct(Long key);


}
