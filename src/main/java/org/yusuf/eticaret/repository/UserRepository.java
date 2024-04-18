package org.yusuf.eticaret.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.yusuf.eticaret.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
