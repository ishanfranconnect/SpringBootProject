package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
        this.productRepository=productRepository;
    }
    @Override
    public void run(String... args)throws Exception{
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // first we create the category
        Category electronics=new Category();
        electronics.setName("Electronics");

        Category clothing=new Category();
        clothing.setName("clothing");


        Category home=new Category();
        home.setName("Home and kitchen");

        // categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

        categoryRepository.save(electronics);
        categoryRepository.save(clothing);
        categoryRepository.save(home);


        // product creation
        Product phone=new Product();
        phone.setName("SmartPhone");
        phone.setDescription("Latest model smart phone with latest features");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);



        Product laptop=new Product();
        laptop.setName("laptop");
        laptop.setDescription("high performance laptop for work and play");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);


        Product jacket=new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and cozy cloth of the winter");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(199.99);
        jacket.setCategory(clothing);


        Product blender=new Product();
        blender.setName("blender");
        blender.setDescription("high speed blender for the smoothly and more");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(299.99);
        blender.setCategory(home);


        productRepository.saveAll(Arrays.asList(phone,laptop,jacket,blender));

    }

}
