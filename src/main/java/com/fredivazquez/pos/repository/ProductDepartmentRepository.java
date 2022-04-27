package com.fredivazquez.pos.repository;

import com.fredivazquez.pos.models.ProductDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDepartmentRepository extends JpaRepository<ProductDepartment, Long> {
}
