package com.yantodev.transaksi.service.order;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.common.payload.BaseResponseOrder;
import com.yantodev.transaksi.module.order.payload.OrderRequestDto;

import java.util.List;

public interface OrderService {
    BaseResponse inputOrder(OrderRequestDto orderRequestDto);
    BaseResponseOrder getAll();
}
