package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.BasketDto;
import org.example.eticaret.dto.BasketItemDto;
import org.example.eticaret.entity.Basket;
import org.example.eticaret.entity.BasketItem;
import org.example.eticaret.entity.Customer;
import org.example.eticaret.entity.Product;
import org.example.eticaret.repository.BasketRepository;
import org.example.eticaret.service.*;
import org.example.eticaret.service.mapper.BasketServiceMapper;
import org.example.eticaret.service.mapper.CustomerServiceMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
     private final BasketRepository repository;
     private final BasketItemService basketItemService;
     private final ProductService productService;
     private final CategoryService categoryService;
     private final CustomerService customerService;

     public final int BASKET_STATUS_NONE=0;

      /*
    1-) basket yok direkt ürünü ekle
    2-) Basket var
           Eklenen ürün sepette varmı
                1-) varsa quantity artır total amount artır
                2-) yoksa yeni ürünü ekle
     */

    @Override
    public BasketDto addProductToBasket(BasketDto basketDto) {


        //müşteri ID ve sepet durumu ile aktif sepeti bulur
        Basket basket=repository.findBasketByCustomer_CustomerIdAndStatusEquals(basketDto.getCustomer().getCustomerId(),BASKET_STATUS_NONE);
        if (basket != null){
            return sepetVarUrunEKle(basket,basketDto);
        }else {
            return sepetYokYeniSepetOlustur(basketDto);
        }

    }



    @Override
    public BasketDto getBasketByCustomerId(String customerId) {
        Basket basket=repository.findBasketByCustomer_CustomerIdAndStatusEquals(Integer.parseInt(customerId),BASKET_STATUS_NONE);
        return BasketServiceMapper.toDto(basket);
    }


    @Override
    public void removeProductFromBasket(String basketItemId) {
        basketItemService.delete(Integer.parseInt(basketItemId));
    }

    private BasketDto sepetVarUrunEKle(Basket basket, BasketDto basketDto) {
        List<BasketItem> basketItemList=basket.getBasketItemList(); //sepette mevcut ürünlerin listesi
        BasketItem basketItem=basketItemService.findBasketItemByBasketIdAndProductId(basket.getBasketId(),basketDto.getBasketItemList().get(0).getProduct().getId());
        if (basketItem ==null){  //Eğer ürün sepette yoksa yeni bir ürün eklenir
            System.out.println("Eklenen ürün sepette yok");
            BasketItem newBasketItem=new BasketItem();
            Product product=findProductById(basketDto.getBasketItemList().get(0).getProduct().getId());
            //Product product=basketItem.getProduct();//ürünü sepette olmayan bir ürün olarak alıyor bunun içinde 58. satır gereklidir
            newBasketItem.setProduct(product);
            newBasketItem.setBasket(basket);
            newBasketItem.setCount(basketDto.getBasketItemList().get(0).getCount());
            newBasketItem.setBasketItemTotalPrice(basketDto.getBasketItemList().get(0).getCount()*product.getPrice());

            basketItemList.add(newBasketItem);

        } else {  //ürün sepetete varsa miktar güncellenir
            System.out.println("Ekelenen ürün sepette var");
            System.out.println("liste var mı"+basketDto.getBasketItemList());
            System.out.println("basketItemList boş mu"+basketDto.getBasketItemList().get(0).getProduct().getName());
            System.out.println("BasketItem"+basketItem);

            //Eklenen ürün sepette var
            Product product=basketItem.getProduct();//mevcut ürünü alıyorum
            basketItem.setProduct(product);
            basketItem.setCount(basketDto.getBasketItemList().get(0).getCount());
            basketItem.setBasket(basket);
            basketItem.setBasketItemTotalPrice(basketDto.getBasketItemList().get(0).getCount()*product.getPrice());//yeni toplam fiyat belirlenir
        }

        basket.setTotalPrice(calculateBasketAmount(basket.getBasketId()));//sepet toplamı hesaplanır
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


    private Product findProductById(int productId) {
        return BasketServiceMapper.toEntity(categoryService,productService.getProduct(productId));
    }

    private BasketDto sepetYokYeniSepetOlustur(BasketDto basketDto) {
        Basket basket=new Basket();
        Customer customer=findCustomerById(String.valueOf(basketDto.getCustomer().getCustomerId()));
        basket.setCustomer(customer);
        basket.setStatus(BASKET_STATUS_NONE);
        List<BasketItem> basketItemList=new ArrayList<>();
        for(BasketItemDto basketItemDto:basketDto.getBasketItemList()){
            BasketItem basketItem=new BasketItem();
            basketItem.setBasketItemTotalPrice(basketItemDto.getCount());
            basketItem.setProduct(findProductById(basketItemDto.getProduct().getId()));
            basketItem.setBasket(basket);
            basketItem.setCount(basketItemDto.getCount());
            basketItemList.add(basketItem);

        }
        basket.setBasketItemList(basketItemList);
        basket.setTotalPrice(basket.getBasketItemList().get(0).getCount()*basketItemList.get(0).getProduct().getPrice());

        return BasketServiceMapper.toDto(repository.save(basket));
    }


    public Customer findCustomerById(String id) {
        return CustomerServiceMapper.toEntity(customerService.getCustomer(Long.valueOf(id)));
    }


}
