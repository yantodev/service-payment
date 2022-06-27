package com.yantodev.transaksi.endpoint.Impl;

import com.yantodev.transaksi.dao.UserRepository;
import com.yantodev.transaksi.dto.user.request.RequestUpdateUserDto;
import com.yantodev.transaksi.dto.user.request.RequestUserDto;
import com.yantodev.transaksi.dto.user.response.ResponseUserDto;
import com.yantodev.transaksi.endpoint.IUserEndpoint;
import com.yantodev.transaksi.model.User;
import com.yantodev.transaksi.service.user.IUserService;
import com.yantodev.transaksi.util.EndPointException;
import com.yantodev.transaksi.util.IResultDTO;
import com.yantodev.transaksi.util.ServiceException;
import com.yantodev.transaksi.util.core.dto.APIResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.regex.Pattern;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
public class UserEndpointImpl implements IUserEndpoint {

    private final IUserService userService;
    private final UserRepository userRepository;

    @Override
    public IResultDTO<ResponseUserDto> addUser(RequestUserDto requestUserDto, HttpServletRequest request) throws EndPointException, ServiceException {
        ResponseUserDto responseUserDto;
        User user = userRepository.findByEmail(requestUserDto.getEmail());
        try {
            String emailRgx = "^([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})";
            String passwordRgx = "^[a-zA-Z0-9@\\\\#$%&*()_+\\]\\[';:?.,!^-]{8,}$";

            boolean emailTrue = Pattern.matches(emailRgx, requestUserDto.getEmail());
            boolean passwordTrue = Pattern.matches(passwordRgx, requestUserDto.getPassword());
            if (!emailTrue) {
                return APIResponseBuilder.noContent(null, "Email " + requestUserDto.getEmail() + " is not valid ");
            }
            if (!passwordTrue) {
                return APIResponseBuilder.noContent(null, "Password is not valid, please use at least 8 characters, at least 1 special character and 1 number");
            }
            if (Objects.nonNull(user)) {
                return APIResponseBuilder.noContent(null, "Email " + requestUserDto.getEmail() + " is already registered");
            }
            responseUserDto = userService.addUser(requestUserDto);
            return APIResponseBuilder.ok(responseUserDto);

        } catch (ServiceException e) {
            log.error("Error while add user {}", e);
            return APIResponseBuilder.internalServerError(null, e, e.getMessage(), request);
        }
    }

    @Override
    public IResultDTO<ResponseUserDto> updateUser(RequestUpdateUserDto requestUpdateUserDto, HttpServletRequest request) throws ServiceException {
        return null;
    }
}
