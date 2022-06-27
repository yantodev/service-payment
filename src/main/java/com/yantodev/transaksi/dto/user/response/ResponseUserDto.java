package com.yantodev.transaksi.dto.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseUserDto {
    String email;
    String name;
    String token;
}
