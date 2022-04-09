package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory saveProductCategory(ProductCategory category);
    List<ProductCategory> getProductCategories();
    ProductCategory getProductCategoryByName(String categoryName);
}
