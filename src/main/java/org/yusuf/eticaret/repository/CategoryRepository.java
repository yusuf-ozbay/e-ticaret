package org.yusuf.eticaret.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yusuf.eticaret.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
