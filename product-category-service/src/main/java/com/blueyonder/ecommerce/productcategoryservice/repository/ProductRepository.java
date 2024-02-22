package com.blueyonder.ecommerce.productcategoryservice.repository;

import com.blueyonder.ecommerce.productcategoryservice.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.productName=:productName")

    Optional<Product> findByName(String productName);
    Optional<Product> findByDescription(String productDescription);

    List<Product> findAll();
}
