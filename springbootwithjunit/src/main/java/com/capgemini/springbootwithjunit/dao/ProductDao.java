package com.capgemini.springbootwithjunit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springbootwithjunit.entity.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
