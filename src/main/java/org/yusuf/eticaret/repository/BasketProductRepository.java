package org.yusuf.eticaret.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yusuf.eticaret.entity.BasketProduct;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {

    BasketProduct findBasketProductByBasket_IdAndProduct_Id(long basketId,long ProductId);

}
