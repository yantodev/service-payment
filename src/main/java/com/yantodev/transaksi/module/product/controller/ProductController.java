package com.yantodev.transaksi.module.product.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.Product;
import com.yantodev.transaksi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;


    @PostMapping("/add-product")
    public BaseResponse addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @GetMapping("")
    public BaseResponse getProduct(){
        return productService.getAll();
    }
}
