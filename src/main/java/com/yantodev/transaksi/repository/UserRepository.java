package com.yantodev.transaksi.repository;

import com.yantodev.transaksi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByIdAndIsDeleted(Long id, Integer isDeleted);
}
