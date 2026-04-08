package com.ecom.productcatalog.controller;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.service.ProductService;
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class NewProductfilteringController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }    
    @GetMapping
    public Page<Product> getAllProducts(Pageable pageable){
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Deleted Successfully";
    }

    @GetMapping("/price/above/{price}")
    public List<Product>getProductsAbovePrice(@PathVariable Double Price){
        return productService.getProductsAbovePrice(price);
    }
  @GetMapping("/filter")
  public List<Product>filterProducts(
    @RequestParam(required=false) String name;
     @RequestParam(required=false) Double minPrice;
     @RequestParam(required=false) Double maxPrice;
  @RequestParam(required=false) Long CategoryId;
  ){
    return productService.searchProducts(keyword);
  }
@GetMapping("/search")
  public List<Product>searchProduct(@RequestParam String keyword){
    return ProductService.searchProducts(keyword);
  }
}
