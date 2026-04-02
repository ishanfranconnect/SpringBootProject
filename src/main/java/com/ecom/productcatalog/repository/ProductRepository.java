package com.ecom.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.productcatalog.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
