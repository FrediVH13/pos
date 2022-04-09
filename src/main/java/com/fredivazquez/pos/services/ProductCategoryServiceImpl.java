package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.ProductCategory;
import com.fredivazquez.pos.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory category) {
        return repository.save(category);
    }

    @Override
    public List<ProductCategory> getProductCategories() {
        return repository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryByName(String categoryName) {
        return repository.findProductCategoryByCategoryName(categoryName);
    }
}
