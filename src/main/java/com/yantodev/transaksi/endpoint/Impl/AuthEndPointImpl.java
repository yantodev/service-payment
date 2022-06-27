package com.yantodev.transaksi.endpoint.Impl;

import com.yantodev.transaksi.util.IResultDTO;
import com.yantodev.transaksi.util.ServiceException;
import com.yantodev.transaksi.util.core.dto.APIResponseBuilder;
import com.yantodev.transaksi.dto.auth.request.RequestUserAuthDto;
import com.yantodev.transaksi.dto.user.response.ResponseUserDto;
import com.yantodev.transaksi.endpoint.IAuthEndPoint;
import com.yantodev.transaksi.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
public class AuthEndPointImpl implements IAuthEndPoint {
    private final IUserService userService;

    @Override
    public IResultDTO<ResponseUserDto> login(RequestUserAuthDto requestUserAuthDto, HttpServletRequest request) {
        ResponseUserDto responseUserDto;
        try {
            responseUserDto = userService.loginUser(requestUserAuthDto);
            return APIResponseBuilder.ok(responseUserDto);
        } catch (ServiceException e) {
            log.error("Error login user", e.getMessage());
            return APIResponseBuilder.internalServerError(null,e, e.getMessage(), request);
        }
    }
}

