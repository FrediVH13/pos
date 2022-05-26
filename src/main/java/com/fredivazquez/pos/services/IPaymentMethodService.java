package com.fredivazquez.pos.services;

import com.fredivazquez.pos.models.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {
    List<PaymentMethod> getPaymentMethods();
}
