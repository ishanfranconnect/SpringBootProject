package com.ecom.productcatalog.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.ProductRepository;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public List<Product>getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product>getProductByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }
    
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public Product updateProduct(Long id, Product product){
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());

        return productRepository.save(existingProduct);
    }
}
