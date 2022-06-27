package com.yantodev.transaksi.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.http.HttpStatus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class AResponseDTO {
    @JsonProperty("responseCode")
    @JsonDeserialize(
            converter = ResponseCodeConverter.class
    )
    private Integer responseCode;
    private String responseMsg;

    public void setResponseCode(Integer value) {
        this.responseCode = value;
    }

    @JsonIgnore
    public void setResponseCode(HttpStatus value) {
        this.responseCode = value.value();
    }

    public boolean equals(HttpStatus o) {
        return this.responseCode.equals(o.value());
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMsg() {
        return this.responseMsg;
    }

    public void setResponseMsg(final String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public AResponseDTO() {
    }

    public AResponseDTO(final Integer responseCode, final String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

    private static class ResponseCodeConverter extends StdConverter<String, Integer> {
        private ResponseCodeConverter() {
        }

        public Integer convert(String value) {
            return Integer.valueOf(value.replaceAll("\\D+", ""));
        }
    }
}
