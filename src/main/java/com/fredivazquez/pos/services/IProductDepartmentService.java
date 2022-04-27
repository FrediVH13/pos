package com.fredivazquez.pos.services;


import com.fredivazquez.pos.models.ProductDepartment;

import java.util.List;

public interface IProductDepartmentService {
    List<ProductDepartment> getProductDepartments();
}
