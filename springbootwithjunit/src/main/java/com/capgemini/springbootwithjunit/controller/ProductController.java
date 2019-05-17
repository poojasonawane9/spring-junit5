package com.capgemini.springbootwithjunit.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springbootwithjunit.entity.Product;
import com.capgemini.springbootwithjunit.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping("/new")
	public Set<Product> addNewProduct() {
		
		Set<Product> product = new HashSet<Product>();
		product.add(new Product(1,"Nestle"));
		product.add(new Product(2,"TaTa"));
		service.addProduct(product);
		return product;
	}
	
	@RequestMapping("/newEntry")
	public Product addProductEntry(Product product) {
		return service.addSingleProduct(product);
		
	}
	
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable Integer id) {
		Product product = service.findById(id);
		return product;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteByIdNotFound(@PathVariable("id") int id) {
		return null;
//		if(!(service.deleteProduct(id))) {
//			return
//		}
	}
}
