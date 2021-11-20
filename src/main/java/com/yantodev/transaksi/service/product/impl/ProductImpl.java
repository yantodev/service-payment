package com.yantodev.transaksi.service.product.impl;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.common.payload.CommonMessage;
import com.yantodev.transaksi.model.Product;
import com.yantodev.transaksi.repository.ProductRepository;
import com.yantodev.transaksi.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public BaseResponse getAll() {
        try {
            List<Product> products = productRepository.findAll();
            return new BaseResponse(CommonMessage.FOUND, 200,products);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }

    @Override
    public BaseResponse addProduct(Product product) {
        try {
            Product product1 = new Product();

            product1.setKategoriId(product.getKategoriId());
            product1.setProductName(product.getProductName());
            product1.setAmount(product.getAmount());
            product1.setPrice(product.getPrice());
            product1.setIsDeleted(0);

            productRepository.save(product1);
            return new BaseResponse(CommonMessage.SAVED, 200, product);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.ERROR,400);
        }
    }
}
