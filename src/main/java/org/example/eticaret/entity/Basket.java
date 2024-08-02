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
    private Long basketId;

    @OneToMany(mappedBy = "basket" ,cascade = CascadeType.ALL)
    private List<BasketItem> basketItemList;

    private double totalPrice;
    private int status;

    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

}
