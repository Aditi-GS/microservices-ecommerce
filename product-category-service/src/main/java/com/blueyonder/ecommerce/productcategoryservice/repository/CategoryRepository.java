package com.blueyonder.ecommerce.productcategoryservice.repository;

import com.blueyonder.ecommerce.productcategoryservice.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.categoryName=:categoryName")
    Optional<Category> findByName(String categoryName);
    Optional<Category> findByDescription(String categoryDescription);

    List<Category> findAll();
}
