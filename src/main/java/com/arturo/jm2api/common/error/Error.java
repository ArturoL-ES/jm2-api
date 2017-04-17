package com.arturo.jm2api.common.error;

import org.springframework.http.HttpStatus;

public class Error {
    
    private Integer code;
    private String message;
    private Long timestamp;

    public static Error errorGeneric() {
        Error error = new Error();
        error.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setMessage("ErrorMessage.GENERIC");
        error.setTimestamp(System.currentTimeMillis());
        return error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Error)) return false;

        Error error = (Error) o;

        if (getCode() != null ? !getCode().equals(error.getCode()) : error.getCode() != null) return false;
        return message != null ? message.equals(error.message) : error.message == null;
    }

    @Override
    public int hashCode() {
        int result = getCode() != null ? getCode().hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

}
