package com.train.webstore.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.webstore.domain.Product;
import com.train.webstore.repository.ProductRepository;
import com.train.webstore.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRep;
	
	
	
	public void orderProduct(String prodId, int quantity) {
		
		Product product = productRep.getProductById(prodId);
		if(product.getUnitsInStock()<quantity){
			throw new IllegalArgumentException("商品数量不足，无法完成订购！数量："+quantity);
			
		}
		product.setUnitsInStock(product.getUnitsInStock()-quantity);
		
		
		
		
	}



	public List<Product> getAllProducts() {
		
		return productRep.getAllProducts();
	}



	public List<Product> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRep.getProductsByCategory(category);
	}



	public List<Product> getProductsByFilter(Map<String, List<String>> filterMap) {
		
		return productRep.getProductsByFilter(filterMap);
	}



	public Product getProductById(String pid) {
		// TODO Auto-generated method stub
		return productRep.getProductById(pid);
	}



	public void addProduct(Product prod) {
		productRep.addProduct(prod);
		
	}

}
