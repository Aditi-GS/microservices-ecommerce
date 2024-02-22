package com.blueyonder.ecommerce.productcategoryservice.util;

import com.blueyonder.ecommerce.productcategoryservice.dto.CategoryRequest;
import com.blueyonder.ecommerce.productcategoryservice.dto.CategoryResponse;
import com.blueyonder.ecommerce.productcategoryservice.model.Category;

public class CategoryUtility {
    private CategoryUtility() {
    }

    public static Category mapToCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        return category;
    }

    public static CategoryResponse mapToCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(category.getCategoryId());
        categoryResponse.setCategoryName(category.getCategoryName());
        categoryResponse.setDescription(category.getDescription());
        return categoryResponse;
    }
}
