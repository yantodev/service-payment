package com.yantodev.transaksi.module.product.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.Product;
import com.yantodev.transaksi.service.product.ProductService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yantodev.transaksi.common.payload.CommonJWT.PREFIX;
import static com.yantodev.transaksi.common.payload.CommonJWT.SECRET;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/add-product")
    public BaseResponse addProduct(@RequestBody Product product, @RequestHeader("Authorization") String header){
        String jwtToken = header.replace(PREFIX, "");
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
        String user = claims.get("sub").toString();
        return productService.addProduct(product);
    }
    @GetMapping("")
    public BaseResponse getProduct(){
        return productService.getAll();
    }
}
