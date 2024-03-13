package com.blueyonder.ecommerce.productcategoryservice.service;

import com.blueyonder.ecommerce.productcategoryservice.dto.ProductRequest;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.ProductAlreadyExistsException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.ProductNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.model.Category;
import com.blueyonder.ecommerce.productcategoryservice.model.Product;
import com.blueyonder.ecommerce.productcategoryservice.repository.CategoryRepository;
import com.blueyonder.ecommerce.productcategoryservice.repository.ProductRepository;
import com.blueyonder.ecommerce.productcategoryservice.util.ProductUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    // CREATE
    @Override
    public Product addProduct(ProductRequest productRequest) throws ProductAlreadyExistsException {
        Product product = ProductUtility.mapToProduct(productRequest);
        if (productRepo.findByName(product.getProductName()).isPresent()) {
            log.error("PRODUCT {} ALREADY EXISTS. DUPLICATES NOT ALLOWED.", product.getProductName());
            throw new ProductAlreadyExistsException();
        }
        else {
            log.info("PRODUCT {} SAVED.", product.getProductName());
            return productRepo.save(product);
        }
    }

    // RETRIEVE
    @Override
    public List<Product> getAllProducts() {
        log.info("ALL PRODUCTS RETRIEVED.");
        return productRepo.findAll();
    }

    @Override
    public Product getProductByName(String productName) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findByName(productName);
        if (product.isPresent()) {
            log.info("PRODUCT {} ID: {} RETRIEVED.", product.get().getProductName(), product.get().getProductId());
            return product.get();
        }
        else {
            log.error("PRODUCT NOT FOUND.");
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Product getProductByDescription(String productDescription) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findByDescription(productDescription);
        if (product.isPresent()) {
            log.info("PRODUCT {} ID: {} RETRIEVED.", product.get().getProductName(), product.get().getProductId());
            return product.get();
        } else {
            log.error("PRODUCT WITH DESCRIPTION : {} NOT FOUND.", productDescription);
            throw new ProductNotFoundException();
        }
    }

    // UPDATE
    @Override
    public Product updateProductByName(String productName, Double newPrice, String newDescription) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findByName(productName);
        if(product.isPresent()) {
            if(newPrice != null)
                product.get().setPrice(newPrice);
            if (newDescription != null)
                product.get().setDescription(newDescription);
            log.info("PRODUCT {} UPDATED.", productName);
            return productRepo.save(product.get());
        }
        else {
            log.error("PRODUCT {} NOT FOUND.", productName);
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Product updateProductByDescription(String productDescription, String newName, Double newPrice) throws ProductNotFoundException {
        Optional<Product> product = productRepo.findByDescription(productDescription);
        if(product.isPresent()) {
            if(newName != null)
                product.get().setProductName(newName);
            if(newPrice != null)
                product.get().setPrice(newPrice);
            log.info("PRODUCT {} UPDATED.", product.get().getProductName());
            return productRepo.save(product.get());
        }
        else {
            log.error("PRODUCT WITH DESCRIPTION : {} NOT FOUND.", productDescription);
            throw new ProductNotFoundException();
        }
    }

    // DELETE
    @Override
    public String deleteProductById(Integer productId) throws ProductNotFoundException {
        if (productRepo.existsById(productId)) {
            productRepo.deleteById(productId);
            log.info("PRODUCT {} DELETED.", productId);
            return "Product " + productId +" is deleted.";
        }
        else {
            log.error("PRODUCT {} NOT FOUND.", productId);
            throw new ProductNotFoundException();
        }
    }

    // LINK WITH CATEGORY
    @Override
    public Product linkWithCategory(String productName, String categoryName) throws CategoryNotFoundException, ProductNotFoundException {
        Optional<Product> productOpt = productRepo.findByName(productName);
        if(productOpt.isPresent()) {
            Product product = productOpt.get();
            Optional<Category> category = categoryRepo.findByName(categoryName);
            if (category.isPresent()) {
                // product   | categoryList    | add
                Set<Category> cat = product.getCategoryList();
                cat.add(category.get());
                product.setCategoryList(cat);
                // category   | productList    | add
                // category.get().getProductList().add(product);
                productRepo.save(product);
                //categoryRepo.save(category.get());
                log.info("LINK SUCCESSFUL. {} ----> {}", productName, categoryName);
                return product;
            }
            else {
                log.error("LINK FAILED : CATEGORY {} NOT FOUND.", categoryName);
            }
                throw new CategoryNotFoundException();
        }
        else{
            log.error("LINK FAILED : PRODUCT {} NOT FOUND.", productName);
            throw new ProductNotFoundException();
        }
    }
}
