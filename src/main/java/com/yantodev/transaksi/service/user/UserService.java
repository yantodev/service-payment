package com.yantodev.transaksi.service.user;

import  com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.module.user.payload.UserRequestDto;

public interface UserService {
    BaseResponse getALl();
    BaseResponse addUser(UserRequestDto userRequestDto);
}
