package org.example.eticaret.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;


}
