package com.fredivazquez.pos.controllers;

import com.fredivazquez.pos.models.ProductCategory;
import com.fredivazquez.pos.models.ProductDepartment;
import com.fredivazquez.pos.services.IProductDepartmentService;
import com.fredivazquez.pos.services.ProductCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final IProductDepartmentService departmentService;
    private final ProductCategoryService categoryService;

    public DepartmentController(IProductDepartmentService departmentService, ProductCategoryService categoryService) {
        this.departmentService = departmentService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<ProductDepartment> allProductDepartments() {
        return departmentService.getProductDepartments();
    }

    @GetMapping("categories")
    public List<ProductCategory> allProductCategories() {
        return categoryService.getProductCategories();
    }
}
