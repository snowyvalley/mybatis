package com.train.webstore.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.train.webstore.domain.Product;
import com.train.webstore.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{
	
	List<Product> datas;
	
	
	

	public ProductRepositoryImpl() {
		super();
		datas = new ArrayList<Product>();
		Product iphone = new Product();
		iphone.setProductId("prod001");
		iphone.setName("Iphone x");
		iphone.setDesc("iphone x is good");
		iphone.setCategory("phone");
		iphone.setManufacturer("apple");
		iphone.setPrice(8000.0);
		iphone.setUnitsInStock(100l);
		datas.add(iphone);
		
		Product xiaomi = new Product();
		xiaomi.setProductId("prod002");
		xiaomi.setName("小米手机");
		xiaomi.setDesc("雷军nb");
		xiaomi.setCategory("phone");
		xiaomi.setManufacturer("xiaomi");
		xiaomi.setPrice(3000.0);
		xiaomi.setUnitsInStock(100l);
		
		datas.add(xiaomi);
		
		Product tv = new Product();
		tv.setProductId("prod003");
		tv.setName("sony tv");
		tv.setDesc("sony大法好");
		tv.setCategory("tv");
		tv.setManufacturer("sony");
		tv.setPrice(7000.0);
		tv.setUnitsInStock(100l);
		
		datas.add(tv);
		
		Product tv2 = new Product();
		tv2.setProductId("prod004");
		tv2.setName("Tcl tv");
		tv2.setDesc("Tcl大法更好");
		tv2.setCategory("tv");
		tv2.setManufacturer("tcl");
		tv2.setPrice(17000.0);
		tv2.setUnitsInStock(100l);
		
		datas.add(tv2);
		
		
		
	}




	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return datas;
	}




	public Product getProductById(String productID) {
		
		Product product = null;
		
		for(Product prod :datas){
			if(productID.equals(prod.getProductId())){
				return prod;
			}
		}
		if(product == null){
			throw new IllegalArgumentException("商品不存在：商品id："+productID);
		}
		return product;
		
	}




	public List<Product> getProductsByCategory(String category) {
		
		List<Product> productByCategory = new ArrayList<Product>();
		
		for(Product prod :datas){
			if(category.equals(prod.getCategory())){
				productByCategory.add(prod);
			}
		}
		
		
		
		return productByCategory;
	}




	public List<Product> getProductsByFilter(Map<String, List<String>> filterMap) {
		
		List<Product> productsByBrand = new ArrayList<Product>();
		List<Product> productsByCategory = new ArrayList<Product>();
		System.out.println(filterMap);
		
		if(filterMap.containsKey("brand")){
			System.out.println("brand");
			List<String> brandList = filterMap.get("brand");
			for(String brand:brandList){
				System.out.println(brand);
				for(Product product:datas){
					if(product.getManufacturer().equals(brand)){
						productsByBrand.add(product);
					}
				}
				
			}
		}
		
		if(filterMap.containsKey("category")){
			System.out.println("category");
				List<String> categoryList = filterMap.get("category");
				for(String category:categoryList){
					System.out.println(category);
					for(Product product:datas){
						if(product.getCategory().equals(category)){
							productsByCategory.add(product);
						}
					}
					
				}
				
			
		}
		System.out.println(productsByBrand);
		System.out.println(productsByCategory);
	
		//取交集
		productsByBrand.retainAll(productsByCategory);
		
		
		
		
		
		
		return productsByBrand;
	}




	public void addProduct(Product prod) {
		this.datas.add(prod);
		
	}

}
