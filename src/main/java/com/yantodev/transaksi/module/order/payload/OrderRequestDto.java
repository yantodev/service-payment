package com.yantodev.transaksi.module.order.payload;

import lombok.Data;

@Data
public class OrderRequestDto {
    private long userId;
    private long productId;
    private long price;
    private long totalPrice;
    private int amount;
    private int isCancel;
}
