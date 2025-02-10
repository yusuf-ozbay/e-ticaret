package org.example.eticaret.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketItemId;
    private int count;
    private double basketItemTotalPrice;

    @ManyToOne
    @JoinColumn(name = "basketId")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name ="productId")
    private Product product;




}
