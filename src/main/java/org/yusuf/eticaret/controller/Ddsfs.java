/*{package org.yusuf.eticaret.controller;

public class Ddsfs {

    package com.zeren.demoders.entity;

import jakarta.persistence .*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

    @Entity
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Basket {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private int status;
        private double totalPrice;
        @OneToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "user_id")
        private User user;
        @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
        private List<BasketProduct> basketProducts;


    }

}



package com.zeren.demoders.entity;

import jakarta.persistence .*;
        import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int status;
    private double totalPrice;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketProduct> basketProducts;


}
}
*/
 