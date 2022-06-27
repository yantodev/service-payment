package com.yantodev.transaksi.dao;

import com.yantodev.transaksi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
//    Order findByIdAndIsDeleted(Long id, Integer isDeleted);
//
//    //    Order findTotalPrice(Long id, Double price);
//    @Query(value = "SELECT SUM(totak_price) FROM tbl_order", nativeQuery = true)
//    Float selectTotal();
}
