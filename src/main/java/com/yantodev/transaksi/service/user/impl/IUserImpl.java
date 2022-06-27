package com.yantodev.transaksi.service.user.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.yantodev.transaksi.common.payload.CommonMessage;
import com.yantodev.transaksi.util.ServiceException;
import com.yantodev.transaksi.dao.UserRepository;
import com.yantodev.transaksi.dto.auth.request.RequestUserAuthDto;
import com.yantodev.transaksi.dto.user.request.RequestUserDto;
import com.yantodev.transaksi.dto.user.response.ResponseUserDto;
import com.yantodev.transaksi.model.User;
import com.yantodev.transaksi.service.user.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Service
public class IUserImpl implements IUserService {

    private final UserRepository userRepository;

    @Override
    public ResponseUserDto loginUser(RequestUserAuthDto loginRequest) throws ServiceException {
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if (Objects.isNull(user)) {
            throw new ServiceException(CommonMessage.LOGIN_ERROR);
        }
        String password = loginRequest.getPassword();
        String password2 = user.getPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), password2);

        return ResponseUserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .token(getJWTToken(user.getEmail()))
                .build();
    }

    @Override
    public ResponseUserDto addUser(RequestUserDto requestUserDto) {
        User user = new User();

        String bcryptHashString = BCrypt.withDefaults().hashToString(12, requestUserDto.getPassword().toCharArray());

        user.setName(requestUserDto.getName());
        user.setEmail(requestUserDto.getEmail());
        user.setPassword(bcryptHashString);

        userRepository.save(user);


        return ResponseUserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
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
