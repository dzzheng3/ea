package edu.mum.onlineshoping.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.onlineshoping.domain.Product;
import edu.mum.onlineshoping.domain.ProductType;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Serializable>{

	public List<Product> findByProductNameLikeOrDescriptionLikeAllIgnoreCase(String productName, String description); 
	public List<Product> findByProductType(ProductType productType); 
	public List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
