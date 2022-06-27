package com.yantodev.transaksi.service.user;

import com.yantodev.transaksi.util.ServiceException;
import com.yantodev.transaksi.dto.auth.request.RequestUserAuthDto;
import com.yantodev.transaksi.dto.user.response.ResponseUserDto;
import com.yantodev.transaksi.dto.user.request.RequestUserDto;

public interface IUserService {

//    BaseResponse getALl();
//    BaseResponse addUser(RequestUserDto requestUserDto);
//
    ResponseUserDto loginUser(RequestUserAuthDto requestUserAuthDto) throws ServiceException;
    ResponseUserDto addUser(RequestUserDto requestUserDto) throws ServiceException;
}
