package org.yusuf.eticaret.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.BasketDto;
import org.yusuf.eticaret.dto.BasketProductDto;
import org.yusuf.eticaret.entity.Basket;
import org.yusuf.eticaret.entity.BasketProduct;
import org.yusuf.eticaret.repository.BasketRepository;
import org.yusuf.eticaret.service.mapper.BasketMapper;

import java.util.ArrayList;
import java.util.List;


@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;                           //user'I burda setlemek için bunu bağlamam gerekti

    @Autowired
    BasketProductService basketProductService;         //bunuda aldım çünkü benim Basket entitysinde var ve bunu da setlemem lazım

    private final int BASKET_STATUS_NONE = 0;
    private final int BASKET_STATUS_SALED = 1;


    public BasketDto save(BasketDto basketDto) {
        Basket basket = basketRepository.findByUser_IdAndStatusEquals(basketDto.getUserId(), BASKET_STATUS_NONE);
        if (basket != null) {
            return sepetVarYeniUrunEkle(basket, basketDto);
        } else {
            return sepetYokUrunEkle(basketDto);
        }

    }

    private BasketDto sepetYokUrunEkle(BasketDto basketDto) {
        Basket basket = new Basket();
        basket.setUser(userService.findById(basketDto.getUserId()));
        basket.setStatus(BASKET_STATUS_NONE);
        List<BasketProduct> basketProducts = new ArrayList<>();

        for (BasketProductDto basketProductDto : basketDto.getBasketProducts()) {
            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setBasket(basket);
            basketProduct.setProduct(productService.findById(basketProductDto.getProductId()));
            basketProduct.setCount(basketProductDto.getCount());
            basketProduct.setTotalPrice(totalPriceHesapla(basketProduct.getProduct().getPrice(), basketProduct.getCount()));
            basketProduct = basketProductService.save(basketProduct);
            basketProducts.add(basketProduct);

        }

        basket.setBasketProducts(basketProducts);
        basket.setTotalPrice(basketinTotalPriceHesapla(basketProducts));
        basket = basketRepository.save(basket);
        return BasketMapper.toDto(basket);

    }


    private double basketinTotalPriceHesapla(List<BasketProduct> basketProducts) {
        double totalPrice = 0;
        for (BasketProduct basketProduct : basketProducts) {

            totalPrice += basketProduct.getTotalPrice();
        }
        return totalPrice;
    }


    private Double totalPriceHesapla(double price, Integer count) {
        double totalPrice = price * count;
        return totalPrice;

    }

    private BasketDto sepetVarYeniUrunEkle(Basket basket, BasketDto basketDto) {
        List<BasketProduct> basketProducts = basket.getBasketProducts();
        BasketProduct product = basketProductService.findBasketProductByBasket_IdAndProduct_Id(basket.getId(), basketDto.getBasketProducts().get(0).getProductId());

        if (product == null) {

            BasketProduct basketProduct = new BasketProduct();
            for (BasketProductDto basketProductDto : basketDto.getBasketProducts()) {
                basketProduct.setBasket(basket);
                basketProduct.setCount(basketProductDto.getCount());
                basketProduct.setProduct(productService.findById(basketProductDto.getProductId()));
                basketProduct.setTotalPrice(totalPriceHesapla(basketProduct.getProduct().getPrice(), basketProduct.getCount()));
                basketProduct = basketProductService.save(basketProduct);
                basketProducts.add(basketProduct);
            }
        } else {
            for (BasketProductDto basketProductDto : basketDto.getBasketProducts()) {

                product.setCount(product.getCount() + basketProductDto.getCount());
                product.setTotalPrice(totalPriceHesapla(product.getProduct().getPrice(), product.getCount()));
                basketProductService.save(product);

            }

        }
        basket.setTotalPrice(basketinTotalPriceHesapla(basketProducts));
        basket.setBasketProducts(basketProducts);
        return BasketMapper.toDto(basket);
    }








}

