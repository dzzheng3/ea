package edu.mum.onlineshoping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.onlineshoping.model.Product;
import edu.mum.onlineshoping.repository.ProductRepository;
import edu.mum.onlineshoping.service.ProductService;

@Service
@Transactional

public class ProdcutServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;

	

	@Override
	public Product getProductById(Long key) {
		return productRepository.findOne(key);
	}

	
	@Override
	public void delete(Long id) {
		productRepository.delete(id);
		
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		
		return (List<Product>) productRepository.findAll();
	}


	/*@Override
	public void updateProduct(Long key) {
		productRepository.updateProduct();
	}*/

}
