package com.yantodev.transaksi.module.user.payload;

import lombok.Data;

@Data
public class UserRequestDto {
    String email;
    String password;
    String name;
}
