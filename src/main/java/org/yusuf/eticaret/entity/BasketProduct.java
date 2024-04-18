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
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int count;
    private double totalPrice;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private Basket basket;


    public BasketProduct(long id,int count){
        this.id=id;
        this.count=count;
    }
}
