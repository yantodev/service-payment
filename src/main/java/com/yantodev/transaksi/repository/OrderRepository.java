package com.yantodev.transaksi.repository;

import com.yantodev.transaksi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByIdAndIsDeleted(Long id, Integer isDeleted);
//    Order findTotalPrice(Long id, Double price);
    @Query(value = "SELECT SUM(totak_price) FROM tbl_order", nativeQuery = true)
    Float selectTotal();
}
