package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.entity.BasketProduct;
import org.yusuf.eticaret.repository.BasketProductRepository;

@Service
public class BasketProductService {

    @Autowired
    BasketProductRepository basketProductRepository;

    public BasketProduct save(BasketProduct basketProduct){
        return basketProductRepository.save(basketProduct);
    }

    public BasketProduct findBasketProductByBasket_IdAndProduct_Id(long basketId , long productId){
        return basketProductRepository.findBasketProductByBasket_IdAndProduct_Id(basketId,productId);

    }


}
