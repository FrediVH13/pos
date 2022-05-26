package com.fredivazquez.pos.repository;

import com.fredivazquez.pos.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    List<PaymentMethod> findAllByOrderByKeyAsc();
}
