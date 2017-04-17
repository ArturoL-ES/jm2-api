package com.arturo.jm2api.common.error;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(exclude = "timestamp")
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

}
