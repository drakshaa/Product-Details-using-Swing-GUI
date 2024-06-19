package com.service;
import com.model.Product;
import java.util.List;

public interface ProductService {
	
	void addProduct(Product prod);
	
	void deleteProduct(int index);
	
	List<Product> getAllProducts();
	
	void updateProduct(Product p);
	
}
