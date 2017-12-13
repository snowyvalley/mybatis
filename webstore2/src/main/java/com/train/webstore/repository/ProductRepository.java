package com.train.webstore.repository;

import java.util.List;
import java.util.Map;

import com.train.webstore.domain.Product;

public interface ProductRepository {
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String productID);
	
	public List<Product> getProductsByCategory(String category);
	
	public List<Product> getProductsByFilter(Map<String,List<String>> filterMap);
	
	public void addProduct(Product prod);

}
