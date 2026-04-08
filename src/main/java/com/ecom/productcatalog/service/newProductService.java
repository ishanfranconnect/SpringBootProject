package com.ecom.productcatalog.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.ProductRepository;

@Service
public class newProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product){
        Product existing = getProductById(id);

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setImageUrl(product.getImageUrl());
        existing.setCategory(product.getCategory());

        return productRepository.save(existing);
    }

  
    public void deleteProduct(Long id){
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public List<Product> filterProducts(String name, Double minPrice, Double maxPrice, Long categoryId){
        return productRepository.findAll().stream()
                .filter(p -> name == null || p.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .filter(p -> categoryId == null || p.getCategory().getId().equals(categoryId))
                .toList();
    }

    public List<Product> searchProducts(String keyword){
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }
}
