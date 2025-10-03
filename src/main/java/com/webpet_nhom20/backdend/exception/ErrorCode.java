package com.webpet_nhom20.backdend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001,"Invalid message key",HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002 , "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003,"Username must be at least 3 character",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID1(1004,"Password must be at least 8 character",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTS(1005,"User existed",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006,"Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007,"You do not have permission",HttpStatus.FORBIDDEN),
    SUCCESS(1008,"Success",HttpStatus.OK),
    EMAIL_EXISTED(1009,"EMAIL EXISTED", HttpStatus.BAD_REQUEST),
    EMAIL_INVALID(1010,"Email format is invalid", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID2(1011,"Password must contain at least one letter and one number", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_BLANK(1012, "Password must not be blank", HttpStatus.BAD_REQUEST),
    USERNAME_NOT_BLANK(1013,"Username must not be blank", HttpStatus.BAD_REQUEST),
    EMAIL_NOT_BLANK(1014,"Email must not be blank", HttpStatus.BAD_REQUEST),
    FULLNAME_NOT_BLANK(1015,"Fullname must not be blank", HttpStatus.BAD_REQUEST),
    PHONE_NOT_BLANK(1016,"Phone must not be blank", HttpStatus.BAD_REQUEST),
    USER_DELETED(1017,"User deleted", HttpStatus.OK);

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
