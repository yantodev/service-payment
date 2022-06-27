package com.yantodev.transaksi.util.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yantodev.transaksi.util.AResponseDTO;
import com.yantodev.transaksi.util.IResultDTO;

import java.io.Serializable;
import java.util.Map;

public class BaseResultDTO<T, U extends AResponseDTO> implements Serializable, IResultDTO {
    private static final long serialVersionUID = -2741720415995551498L;
    @JsonProperty("result")
    private T result;
    @JsonProperty("responseData")
    private U responseData;
    @JsonProperty("metaData")
    private Map<String, String> metaData;

    public BaseResultDTO() {
    }

    public T getResult() {
        return this.result;
    }

    public U getResponseData() {
        return this.responseData;
    }

    public Map<String, String> getMetaData() {
        return this.metaData;
    }

    @JsonProperty("result")
    public void setResult(final T result) {
        this.result = result;
    }

    @JsonProperty("responseData")
    public void setResponseData(final U responseData) {
        this.responseData = responseData;
    }

    @JsonProperty("metaData")
    public void setMetaData(final Map<String, String> metaData) {
        this.metaData = metaData;
    }
}
