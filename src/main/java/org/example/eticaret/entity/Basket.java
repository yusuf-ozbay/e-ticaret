package org.example.eticaret.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;
    private double totalPrice;
    private int status;

    @OneToMany(mappedBy = "basket" ,cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
