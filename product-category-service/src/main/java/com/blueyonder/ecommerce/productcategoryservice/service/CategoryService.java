package com.blueyonder.ecommerce.productcategoryservice.service;

import com.blueyonder.ecommerce.productcategoryservice.dto.CategoryRequest;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryAlreadyExistsException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.model.Category;

import java.util.List;

public interface CategoryService {
    // CREATE
    public Category addCategory(CategoryRequest categoryRequest) throws CategoryAlreadyExistsException;

    // RETRIEVE
    public List<Category> getAllCategories();
    // public Category getCategoryById(Integer categoryId) throws CategoryNotFoundException;
    public Category getCategoryByName(String categoryName) throws CategoryNotFoundException;
    public Category getCategoryByDescription(String categoryDescription) throws CategoryNotFoundException;

    // UPDATE
    // Category updateCategoryById(Integer categoryId, String newName, String newDescription) throws CategoryNotFoundException;

    Category updateCategoryByName(String categoryName, String newDescription) throws CategoryNotFoundException;

    Category updateCategoryByDescription(String categoryDescription, String newName) throws CategoryNotFoundException;

    // DELETE
    public String deleteCategoryById(Integer categoryId) throws CategoryNotFoundException;
}
