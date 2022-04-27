package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.ProductDepartment;
import com.fredivazquez.pos.repository.ProductDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDepartmentServiceImpl implements IProductDepartmentService{

    private final ProductDepartmentRepository repository;

    public ProductDepartmentServiceImpl(ProductDepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDepartment> getProductDepartments() {
        return repository.findAll();
    }
}
