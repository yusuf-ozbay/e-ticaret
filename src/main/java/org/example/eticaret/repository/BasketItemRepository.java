package org.example.eticaret.repository;

import org.example.eticaret.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Long> {
}
