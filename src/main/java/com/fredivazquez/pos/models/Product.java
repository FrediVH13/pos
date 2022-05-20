package com.fredivazquez.pos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "wholesale_price")
    private Double wholesalePrice;

    @Column(name = "units_in_stock", nullable = false)
    private int unitsInStock;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

}
