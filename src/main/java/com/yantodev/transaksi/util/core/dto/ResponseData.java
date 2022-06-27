package com.yantodev.transaksi.util.core.dto;

import com.yantodev.transaksi.util.AResponseDTO;

import java.io.Serializable;

public class ResponseData extends AResponseDTO implements Serializable {
    private static final long serialVersionUID = 4838859848024990861L;

    public ResponseData(String responseCode, String responseMessage) {
        this.setResponseCode(Integer.parseInt(responseCode));
        this.setResponseMsg(responseMessage);
    }

    public ResponseData(int responseCode, String responseMessage) {
        this.setResponseCode(responseCode);
        this.setResponseMsg(responseMessage);
    }

    public ResponseData() {
    }
}
