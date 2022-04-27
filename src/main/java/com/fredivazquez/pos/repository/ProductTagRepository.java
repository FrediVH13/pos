package com.fredivazquez.pos.repository;

import com.fredivazquez.pos.models.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Long> {
}
