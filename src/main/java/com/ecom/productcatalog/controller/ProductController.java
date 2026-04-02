package com.ecom.productcatalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/api/products/category/{categoryId}")
    public List<Product> getAllProductByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }

}
