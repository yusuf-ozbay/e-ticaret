package org.yusuf.eticaret.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yusuf.eticaret.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket findByUser_IdAndStatusEquals(Long userId, int status);
}








