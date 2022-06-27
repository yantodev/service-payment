package com.yantodev.transaksi.endpoint;

import com.yantodev.transaksi.dto.user.request.RequestUpdateUserDto;
import com.yantodev.transaksi.util.EndPointException;
import com.yantodev.transaksi.util.IResultDTO;
import com.yantodev.transaksi.util.ServiceException;
import com.yantodev.transaksi.config.statval.IApplicationConstant;
import com.yantodev.transaksi.dto.user.request.RequestUserDto;
import com.yantodev.transaksi.dto.user.response.ResponseUserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = IApplicationConstant.ContextPath.USER_V1,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface IUserEndpoint {
    @PostMapping(value = IApplicationConstant.path.user.ADD_USER)
    IResultDTO<ResponseUserDto> addUser(@RequestBody RequestUserDto requestUserDto, HttpServletRequest request) throws EndPointException, ServiceException;

    @PutMapping(value = IApplicationConstant.path.user.UPDATE_USER)
    IResultDTO<ResponseUserDto> updateUser(@RequestBody RequestUpdateUserDto requestUpdateUserDto, HttpServletRequest request) throws ServiceException;
}
