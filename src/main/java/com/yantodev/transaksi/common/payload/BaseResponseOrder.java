package com.yantodev.transaksi.common.payload;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseResponseOrder<T> implements Serializable {
    private static final  long serialVersionUID = -6233145663410668178L;
    private Integer code = 999;
    private String message;
    private T data;
    private Float totalPayment;


    public BaseResponseOrder(String message, Integer code, T data, Float totalPayment){
        this.code = code;
        this.message = message;
        this.data = data;
        this.totalPayment = totalPayment;
    }
    public BaseResponseOrder(String message, Integer code){
        this.code = code;
        this.message = message;
        this.data = null;
    }
}
