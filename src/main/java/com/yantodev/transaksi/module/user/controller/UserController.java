package com.yantodev.transaksi.module.user.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.module.user.payload.UserRequestDto;
import com.yantodev.transaksi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public BaseResponse addUser(@RequestBody UserRequestDto userRequestDto){
        return userService.addUser(userRequestDto);
    }
    @GetMapping("")
    public BaseResponse getAll(){
        return userService.getALl();
    }
}
