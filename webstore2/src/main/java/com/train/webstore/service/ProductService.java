package com.train.webstore.service;

import java.util.List;
import java.util.Map;

import com.train.webstore.domain.Product;

public interface ProductService {
	
	
	public void orderProduct(String prodId,int quantity);
	

	public List<Product> getAllProducts();
	
	public List<Product> getProductsByCategory(String category);
	public List<Product> getProductsByFilter(Map<String,List<String>> filterMap);
	
	public Product getProductById(String pid);
	
	public void addProduct(Product prod);
	
	
}
