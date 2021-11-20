package com.yantodev.transaksi.service.user.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.yantodev.transaksi.common.payload.BaseResponse;
import com.yantodev.transaksi.model.User;
import com.yantodev.transaksi.module.user.payload.AuthResponse;
import com.yantodev.transaksi.module.user.payload.LoginRequest;
import com.yantodev.transaksi.module.user.payload.UserRequestDto;
import com.yantodev.transaksi.repository.UserRepository;
import com.yantodev.transaksi.service.user.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import com.yantodev.transaksi.common.payload.*;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
            String bcryptHashString = BCrypt.withDefaults().hashToString(12, userRequestDto.getPassword().toCharArray());
            if(emailTrue && passwordTrue){
                User user = new User();
                user.setName(userRequestDto.getName());
                user.setEmail(userRequestDto.getEmail());
                user.setPassword(bcryptHashString);
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

    @Override
    public BaseResponse loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        String password = loginRequest.getPassword();
        String password2 = user.getPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),password2);
        System.out.println("cek password : " + password);
        System.out.println("cek password2 : " + password2);
        System.out.println("cek result : " + result.verified);
        if (user != null) {
            if(result.verified){
                String token = getJWTToken(user.getEmail());
                AuthResponse authResponse = new AuthResponse();
                authResponse.setName((user.getName()));
                authResponse.setEmail(user.getEmail());
                authResponse.setPassword(user.getPassword());
                authResponse.setToken(token);
                return new BaseResponse(CommonMessage.LOGIN_SUCCESS, 200, authResponse);
            } else {
                return new BaseResponse(CommonMessage.LOGIN_PASSWORD);
            }

//            System.out.println("tokennnnnn : " + authResponse.getToken());

        } else {
            return new BaseResponse(CommonMessage.LOGIN_ERROR);
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
    private static void delay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
