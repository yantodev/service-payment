package com.yantodev.transaksi.module.order.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.module.order.payload.OrderRequestDto;
import com.yantodev.transaksi.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("add-order")
    public BaseResponse addOrder(@RequestBody OrderRequestDto orderRequestDto){
        return orderService.inputOrder(orderRequestDto);
    }
    @GetMapping("")
    public  BaseResponse getOrder(){
        return  orderService.getAll();
    }
}
