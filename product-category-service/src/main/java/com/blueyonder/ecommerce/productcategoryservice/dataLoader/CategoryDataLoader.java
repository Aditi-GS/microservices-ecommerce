package com.blueyonder.ecommerce.productcategoryservice.dataLoader;

import com.blueyonder.ecommerce.productcategoryservice.model.Category;
import com.blueyonder.ecommerce.productcategoryservice.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryDataLoader implements ApplicationRunner {
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create sample categories
        List<Category> sampleData = Arrays.asList(
                new Category(1, "stationery", "school and office", null),
                new Category(2, "fashion", "clothes", null),
                new Category(3, "electronics", "home office and work", null)
        );

        // populate the db
        categoryRepo.saveAll(sampleData);
    }
}

