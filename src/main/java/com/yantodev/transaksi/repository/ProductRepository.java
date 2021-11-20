package com.yantodev.transaksi.repository;

import com.yantodev.transaksi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findByName(String name);
    Product findByIdAndIsDeleted(Long id, Integer isDeleted);
//    List<Product> findByIdIsDeleted(Integer IsDeleted);
}
