package com.fredivazquez.pos.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tags")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag")
    @ToString.Exclude
    @JsonBackReference
    private Set<ProductTag> productTags;

}
