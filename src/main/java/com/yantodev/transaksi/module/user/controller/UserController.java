package com.yantodev.transaksi.module.user.controller;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.module.user.payload.LoginRequest;
import com.yantodev.transaksi.module.user.payload.UserRequestDto;
import com.yantodev.transaksi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public BaseResponse addUser(@RequestBody UserRequestDto userRequestDto){
        return userService.addUser(userRequestDto);
    }
    @PostMapping("/login")
    public BaseResponse userLogin(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

}
