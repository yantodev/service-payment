package com.yantodev.transaksi.dao;

import com.yantodev.transaksi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findByName(String name);
    Product findByIdAndIsDeleted(Long id, Integer isDeleted);
//    List<Product> findByIdIsDeleted(Integer IsDeleted);
}
