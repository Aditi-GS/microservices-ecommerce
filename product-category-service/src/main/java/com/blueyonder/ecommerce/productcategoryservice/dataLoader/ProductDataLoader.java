package com.blueyonder.ecommerce.productcategoryservice.dataLoader;

import com.blueyonder.ecommerce.productcategoryservice.model.Product;
import com.blueyonder.ecommerce.productcategoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductDataLoader implements ApplicationRunner {
    @Autowired
    private ProductRepository productRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create sample products
        List<Product> sampleData = Arrays.asList(
                new Product(1, "classmate book", 50.0, "ruled, spiral bound", null),
                new Product(2, "zudio tshirt", 149.0, "printed, purple", null),
                new Product(3, "jabra headphones", 2500.0, "microphone", null)
        );

        // populate the db
        productRepo.saveAll(sampleData);
    }
}
