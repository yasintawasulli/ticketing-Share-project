package com.cydeo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ResponseWrapper {

    private boolean success;
    private String message;
    private Integer code;
    private Object  data;

    public ResponseWrapper(String message, HttpStatus httpStatus, Object data) {
        this.success = true;
        this.message = message;
        this.code = httpStatus.value();
        this.data = data;
    }

    public ResponseWrapper(String message, HttpStatus httpStatus) {
        this.success = true;
        this.message = message;
        this.code = httpStatus.value();
    }
}
