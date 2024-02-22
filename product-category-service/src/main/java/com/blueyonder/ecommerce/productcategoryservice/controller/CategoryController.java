package com.blueyonder.ecommerce.productcategoryservice.controller;

import com.blueyonder.ecommerce.productcategoryservice.dto.CategoryRequest;
import com.blueyonder.ecommerce.productcategoryservice.dto.CategoryResponse;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryAlreadyExistsException;
import com.blueyonder.ecommerce.productcategoryservice.exceptions.CategoryNotFoundException;
import com.blueyonder.ecommerce.productcategoryservice.service.CategoryService;
import com.blueyonder.ecommerce.productcategoryservice.util.CategoryUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/ecommerce/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add-category")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest) throws CategoryAlreadyExistsException {
        return CategoryUtility.mapToCategoryResponse(categoryService.addCategory(categoryRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories().stream()
                .map(CategoryUtility::mapToCategoryResponse)
                .toList();
    }

    @GetMapping("/get-category-name/{catName}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryByName(@PathVariable String catName) throws CategoryNotFoundException {
        return CategoryUtility.mapToCategoryResponse(categoryService.getCategoryByName(catName));
    }

    @GetMapping("/get-category-description/{catDesc}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse getCategoryByDescription(@PathVariable String catDesc) throws CategoryNotFoundException {
        return CategoryUtility.mapToCategoryResponse(categoryService.getCategoryByDescription(catDesc));
    }

    @PutMapping("/update-category-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse updateCategoryByName(@PathVariable String name, @RequestBody String desc) throws CategoryNotFoundException {
        return CategoryUtility.mapToCategoryResponse(categoryService.updateCategoryByName(name, desc));
    }

    @PutMapping("/update-category-desc/{description}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryResponse updateCategoryByDescription(@PathVariable String description, @RequestBody String name) throws CategoryNotFoundException {
        return CategoryUtility.mapToCategoryResponse(categoryService.updateCategoryByDescription(description, name));
    }

    @DeleteMapping("/delete-category/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteCategory(@PathVariable Integer id) throws CategoryNotFoundException {
        return categoryService.deleteCategoryById(id);
    }
}
