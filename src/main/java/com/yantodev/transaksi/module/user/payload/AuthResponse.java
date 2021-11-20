package com.yantodev.transaksi.module.user.payload;

import lombok.Data;

@Data
public class AuthResponse {
    String name;
    String email;
    String password;
    String token;
}
