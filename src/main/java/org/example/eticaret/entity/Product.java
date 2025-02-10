package org.example.eticaret.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;
    private String description;
    private double price;
    private int stock;

    //fetch = FetchType.EAGER =verileri nasıl getireceğini belirler EAGER ise ben veriyi çağırdığğımda getrir
    //cascade = CascadeType.ALL  burda urun ve kategori sınıflarında  all diyerek her iki tarafta da işlemlerin yapılmasını sağlar

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;


}
