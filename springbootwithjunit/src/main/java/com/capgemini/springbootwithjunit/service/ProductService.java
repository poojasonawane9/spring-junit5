package com.capgemini.springbootwithjunit.service;

import java.util.Optional;
import java.util.Set;

import com.capgemini.springbootwithjunit.entity.Product;

public interface ProductService {
	
	public Product addSingleProduct(Product product);
	public Set<Product> addProduct(Set<Product> product);
	public Product findById(Integer id);
	public void deleteProduct(Integer id);
}
