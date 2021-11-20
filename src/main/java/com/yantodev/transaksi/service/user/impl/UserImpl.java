package com.yantodev.transaksi.service.user.impl;

import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.User;
import com.yantodev.transaksi.module.user.payload.UserRequestDto;
import com.yantodev.transaksi.repository.UserRepository;
import com.yantodev.transaksi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yantodev.transaksi.common.payload.*;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public BaseResponse getALl() {
        try {
            List<User> users = userRepository.findAll();
            return new BaseResponse(CommonMessage.FOUND, CommonCode.SUCCESS, users);
        } catch (Exception e){
            return new BaseResponse(CommonMessage.NOT_FOUND, 400);
        }
    }

    @Override
    public BaseResponse addUser(UserRequestDto userRequestDto) {
        try {
            String emailRgx = "^([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
            String passwordRgx = "^[a-zA-Z0-9@\\\\#$%&*()_+\\]\\[';:?.,!^-]{8,}$";

            boolean emailTrue = Pattern.matches(emailRgx, userRequestDto.getEmail());
            boolean passwordTrue = Pattern.matches(passwordRgx, userRequestDto.getPassword());

            if(emailTrue && passwordTrue){
                User user = new User();
                user.setName(userRequestDto.getName());
                user.setEmail(userRequestDto.getEmail());
                user.setPassword(userRequestDto.getPassword());
                user.setIsDeleted(0);

                userRepository.save(user);
                return  new BaseResponse(CommonMessage.REGISTER_SUCCESS,200, user);
            }else {
                return new BaseResponse(CommonMessage.REGISTER_ERROR,400);
            }

        } catch (Exception e){
            return  new BaseResponse(CommonMessage.REGISTER_ERROR,400);
        }
    }
}
