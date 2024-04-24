package org.yusuf.eticaret.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private double price;

    //fetch = FetchType.EAGER =verileri nasıl getireceğini belirler EAGER ise ben veriyi çağırdığğımda getrir
    //cascade = CascadeType.ALL  burda urun ve kategori sınıflarında  all diyerek her iki tarafta da işlemlerin yapılmasını sağlar

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryId")
    private Category category;

}
