package com.fredivazquez.pos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "purchase_order_lines")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PurchaseOrderLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "sub_total", nullable = false)
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "purchases_id", nullable = false)
    private PurchaseOrder purchaseOrder;

}
