package com.yantodev.transaksi.dto.user.request;

import lombok.Data;

@Data
public class RequestUserDto {
    String email;
    String password;
    String name;
}
