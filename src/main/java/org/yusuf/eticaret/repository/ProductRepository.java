package org.yusuf.eticaret.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yusuf.eticaret.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
