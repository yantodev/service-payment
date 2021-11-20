package com.yantodev.transaksi.module.order.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.common.payload.BaseResponseOrder;
import com.yantodev.transaksi.common.payload.CommonJWT;
import com.yantodev.transaksi.module.order.payload.OrderRequestDto;
import com.yantodev.transaksi.service.order.OrderService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yantodev.transaksi.common.payload.CommonJWT.PREFIX;
import static com.yantodev.transaksi.common.payload.CommonJWT.SECRET;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("add-order")
    public BaseResponse addOrder(@RequestBody OrderRequestDto orderRequestDto, @RequestHeader("Authorization") String header){
        String jwtToken = header.replace(PREFIX, "");
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
        String user = claims.get("sub").toString();
        return orderService.inputOrder(orderRequestDto);
    }
    @GetMapping("")
    public BaseResponseOrder getOrder(@RequestHeader("Authorization") String header){
        String jwtToken = header.replace(PREFIX, "");
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
        String user = claims.get("sub").toString();
        return  orderService.getAll();
    }
}
