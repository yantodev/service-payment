package com.yantodev.transaksi.service.order.impl;

import com.yantodev.transaksi.dao.UserRepository;
import com.yantodev.transaksi.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderImpl implements OrderService {
//    @Autowired
//    OrderRepository orderRepository;
//
//    @Autowired
//    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;

//    @Override
//    public BaseResponse inputOrder(OrderRequestDto orderRequestDto) {
//        System.out.println("order :" + orderRequestDto);
//        try {
//            Order order = new Order();
//            User user = userRepository.findByIdAndIsDeleted(orderRequestDto.getUserId(),0);
//            Product product = productRepository.findByIdAndIsDeleted(orderRequestDto.getProductId(),0);
//
//            if(user != null && product != null){
//                order.setUserId(user);
//                order.setProductId(product);
//                order.setAmount(orderRequestDto.getAmount());
//                order.setTotalPrice(orderRequestDto.getAmount() * product.getPrice());
//                order.setIsCancel(0);
//                orderRepository.save(order);
//                product.setAmount(product.getAmount() - order.getAmount());
//                return  new BaseResponse(CommonMessage.SAVED, CommonCode.SUCCESS, order);
//            } else {
//                return new BaseResponse(CommonMessage.NOT_FOUND,CommonCode.NOT_FOUND);
//            }
//
//        } catch (Exception e){
//            return new BaseResponse(CommonMessage.NOT_SAVED, CommonCode.BAD_REQUEST);
//        }
//    }

//    @Override
//    public BaseResponseOrder getAll() {
//        try {
//            List<Order> orders = orderRepository.findAll();
//            Float totalOrder = orderRepository.selectTotal();
//            return new BaseResponseOrder(CommonMessage.FOUND, CommonCode.SUCCESS, orders, totalOrder);
//        } catch (Exception e) {
//            return new BaseResponseOrder(CommonMessage.NOT_FOUND, CommonCode.BAD_REQUEST);
//        }
//    }
}
