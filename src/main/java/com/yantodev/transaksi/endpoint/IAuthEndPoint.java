package com.yantodev.transaksi.endpoint;

import com.yantodev.transaksi.util.IResultDTO;
import com.yantodev.transaksi.util.ServiceException;
import com.yantodev.transaksi.config.statval.IApplicationConstant;
import com.yantodev.transaksi.dto.auth.request.RequestUserAuthDto;
import com.yantodev.transaksi.dto.user.response.ResponseUserDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = IApplicationConstant.ContextPath.AUTH_V1,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public interface IAuthEndPoint {
    @PostMapping(value = IApplicationConstant.path.auth.LOGIN)
    IResultDTO<ResponseUserDto> login(@RequestBody RequestUserAuthDto requestUserAuthDto, HttpServletRequest request) throws ServiceException;
}
