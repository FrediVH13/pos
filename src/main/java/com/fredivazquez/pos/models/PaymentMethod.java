package com.fredivazquez.pos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class PaymentMethod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "key")
    private String key;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private boolean status;
}
