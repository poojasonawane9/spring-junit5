package com.capgemini.springbootwithjunit.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springbootwithjunit.dao.ProductDao;
import com.capgemini.springbootwithjunit.entity.Product;
import com.capgemini.springbootwithjunit.service.ProductService;

//@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	public Product addSingleProduct(Product product) {
		return dao.save(product);
		
	}

	@Override
	public Set<Product> addProduct(Set<Product> product) {
		dao.saveAll(product);
		return product;
	}

	@Override
	public Product findById(Integer id) {
		return dao.findById(id).get();
	}
	
	@Override
	public void deleteProduct(Integer id) {
		dao.deleteById(id);
	}

	
}
