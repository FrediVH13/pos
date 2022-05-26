package com.fredivazquez.pos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "amount_tendered", nullable = false)
    private double amountTendered;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @ToString.Exclude
    private List<OrderLine> orderLines = new ArrayList<>();

}
