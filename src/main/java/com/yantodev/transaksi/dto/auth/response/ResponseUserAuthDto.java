package com.yantodev.transaksi.dto.auth.response;

import lombok.Data;

@Data
public class ResponseUserAuthDto {
    String name;
    String email;
    String password;
    String token;
}
