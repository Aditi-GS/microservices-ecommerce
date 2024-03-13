package com.blueyonder.ecommerce.productcategoryservice.service;

import com.blueyonder.ecommerce.productcategoryservice.dto.CategoryRequest;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryAlreadyExistsException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.model.Category;
import com.blueyonder.ecommerce.productcategoryservice.repository.CategoryRepository;
import com.blueyonder.ecommerce.productcategoryservice.util.CategoryUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
    private static Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    // CREATE
    @Override
    public Category addCategory(CategoryRequest categoryRequest) throws CategoryAlreadyExistsException {
        Category category = CategoryUtility.mapToCategory(categoryRequest);
        if (categoryRepo.findByName(category.getCategoryName()).isEmpty()) {
            log.info("CATEGORY {} SAVED.", category.getCategoryName());
            return categoryRepo.save(category);
        }
        else {
            log.error("CATEGORY {} ALREADY EXISTS. NO DUPLICATES ALLOWED.", category.getCategoryName());
            throw new CategoryAlreadyExistsException();
        }
    }

    // RETRIEVE
    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategoryByName(String categoryName) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findByName(categoryName);
        if (category.isPresent()) {
            log.info("CATEGORY {} ID: {} RETRIEVED.", categoryName, category.get().getCategoryId());
            return category.get();
        }
        else {
            log.error("CATEGORY {} NOT FOUND.", categoryName);
            throw new CategoryNotFoundException();
        }
    }

    @Override
    public Category getCategoryByDescription(String categoryDescription) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findByDescription(categoryDescription);
        if (category.isPresent()) {
            log.info("CATEGORY {} ID: {} RETRIEVED.", category.get().getCategoryName(), category.get().getCategoryId());
            return category.get();
        }
        else {
            log.error("CATEGORY WITH DESCRIPTION : {} NOT FOUND.", categoryDescription);
            throw new CategoryNotFoundException();
        }
    }

    // UPDATE
    @Override
    public Category updateCategoryByName(String categoryName, String newDescription) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findByName(categoryName);
        if(category.isPresent()) {
            category.get().setDescription(newDescription);
            log.info("CATEGORY {} UPDATED.", categoryName);
            return categoryRepo.save(category.get());
        }
        else {
            log.error("CATEGORY {} NOT FOUND.", categoryName);
            throw new CategoryNotFoundException();
        }
    }

    @Override
    public Category updateCategoryByDescription(String categoryDescription, String newName) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepo.findByDescription(categoryDescription);
        if(category.isPresent()) {
            category.get().setCategoryName(newName);
            log.info("CATEGORY {} UPDATED.", category.get().getCategoryName());
            return categoryRepo.save(category.get());
        }
        else {
            log.error("CATEGORY WITH DESCRIPTION : {} NOT FOUND.", categoryDescription);
            throw new CategoryNotFoundException();
        }
    }

    // DELETE
    @Override
    public String deleteCategoryById(Integer categoryId) throws CategoryNotFoundException {
        if (categoryRepo.existsById(categoryId)) {
            categoryRepo.deleteById(categoryId);
            log.info("CATEGORY {} DELETED.", categoryId);
            return "Category " + categoryId +" is deleted.";
        }
        else{
            log.error("CATEGORY {} DELETION FAILED.", categoryId);
            throw new CategoryNotFoundException();
        }
    }
}
