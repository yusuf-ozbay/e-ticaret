package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.BasketDto;
import org.example.eticaret.entity.Basket;
import org.example.eticaret.entity.BasketItem;
import org.example.eticaret.entity.Product;
import org.example.eticaret.repository.BasketRepository;
import org.example.eticaret.service.BasketItemService;
import org.example.eticaret.service.BasketService;
import org.example.eticaret.service.CategoryService;
import org.example.eticaret.service.ProductService;
import org.example.eticaret.service.mapper.BasketServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
     private final BasketRepository repository;
     private final BasketItemService basketItemService;
     private final ProductService productService;
     private final CategoryService categoryService;

     public final int BASKET_STATUS_NONE=0;

    @Override
    public BasketDto addProductToBasket(BasketDto basketDto) {

        Basket basket=repository.findBasketByCustomer_CustomerIdAndStatusEquals(basketDto.getCustomer().getCustomerId(),BASKET_STATUS_NONE);
        if (basket != null){
            return sepetVarUrunEKle(basket,basketDto);
        }


        return null;
    }

    @Override
    public BasketDto getBasketByCustomerId(String customerId) {
        return null;
    }

    @Override
    public void removeProductFromBasket(String basketItemId) {

    }

    private BasketDto sepetVarUrunEKle(Basket basket, BasketDto basketDto) {
        List<BasketItem> basketItemList=basket.getBasketItemList();
        BasketItem basketItem=basketItemService.findBasketItemByBasketIdAndProductId(basket.getBasketId(),basketDto.getBasketItemList().get(0).getProduct().getId());
        if (basketItem ==null){
            System.out.println("Eklenen ürün sepette yok");
            BasketItem newBasketItem=new BasketItem();
            //Product product=findProductById(basketDto.getBasketItemDtoList().get(0).getProduct().getId());
            Product product=basketItem.getProduct();
            newBasketItem.setProduct(product);
            newBasketItem.setBasket(basket);
            newBasketItem.setCount(basketDto.getBasketItemList().get(0).getCount());
            newBasketItem.setBasketItemTotalPrice(basketDto.getBasketItemList().get(0).getCount()*product.getPrice());

            basketItemList.add(newBasketItem);

        } else {
            System.out.println("Ekelenen ürün sepette var");
            System.out.println("liste var mı"+basketDto.getBasketItemList());
            System.out.println("basketItemList boş mu"+basketDto.getBasketItemList().get(0).getProduct().getName());
            System.out.println("BasketItem"+basketItem);

            //Eklenen ürün sepette var
            Product product=basketItem.getProduct();
            basketItem.setProduct(product);
            basketItem.setCount(basketDto.getBasketItemList().get(0).getCount());
            basketItem.setBasket(basket);
            basketItem.setBasketItemTotalPrice(basketDto.getBasketItemList().get(0).getCount()*product.getPrice());
        }

        basket.setTotalPrice(calculateBasketAmount(basket.getBasketId()));
        basket.setBasketItemList(basketItemList);
        repository.save(basket);
        return BasketServiceMapper.toDto(basket);
    }

    private double calculateBasketAmount(int basketId) {
        Basket basket=repository.findBasketByBasketId(basketId);
        double totalAmount=0.0;
        for (BasketItem basketItem :basket.getBasketItemList()){
            totalAmount += basketItem.getBasketItemTotalPrice();
        }
        return totalAmount;
    }


//    private Product findProductById(int productId) {
//        return BasketServiceMapper.toEntity(categoryService,productService.getProduct(productId));
//    }


}
