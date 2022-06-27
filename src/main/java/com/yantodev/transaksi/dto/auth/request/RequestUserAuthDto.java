package com.yantodev.transaksi.dto.auth.request;

import lombok.Data;

@Data
public class RequestUserAuthDto {
    private String email;
    private String password;
}
