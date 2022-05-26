package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.PaymentMethod;
import com.fredivazquez.pos.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements IPaymentMethodService{

    private final PaymentMethodRepository repository;

    public PaymentMethodServiceImpl(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PaymentMethod> getPaymentMethods() {
        return repository.findAllByOrderByKeyAsc();
    }
}
