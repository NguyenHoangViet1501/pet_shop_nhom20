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
    USER_DELETED(1017,"User deleted", HttpStatus.OK),
    ROLE_NOT_FOUND(1018,"Role not found",HttpStatus.BAD_REQUEST),
    PHONE_EXISTED(1019,"Phone is exist",HttpStatus.BAD_REQUEST),

    // ServiceAppointment
    SERVICE_ID_NOT_NULL(1020, "Service ID không được để trống", HttpStatus.BAD_REQUEST),
    USER_ID_NOT_NULL(1021, "User ID không được để trống", HttpStatus.BAD_REQUEST),
    NAME_PET_NOT_BLANK(1022, "Tên thú cưng không được để trống", HttpStatus.BAD_REQUEST),
    NAME_PET_TOO_LONG(1023, "Tên thú cưng không vượt quá 100 ký tự", HttpStatus.BAD_REQUEST),
    APPOINTMENT_START_NOT_NULL(1024, "Thời gian bắt đầu không được để trống", HttpStatus.BAD_REQUEST),
    APPOINTMENT_START_NOT_FUTURE(1025, "Thời gian bắt đầu phải là thời gian trong tương lai", HttpStatus.BAD_REQUEST),
    NOTES_TOO_LONG(1026, "Ghi chú không vượt quá 500 ký tự", HttpStatus.BAD_REQUEST),
    SPECIE_PET_NOT_BLANK(1027, "Loài thú cưng không được để trống", HttpStatus.BAD_REQUEST),
    SPECIE_PET_TOO_LONG(1028, "Loài thú cưng không vượt quá 100 ký tự", HttpStatus.BAD_REQUEST),

    //UserServiceAppointment
    ROLE_NAME_NOT_NULL(1030, "Role name không được để trống", HttpStatus.BAD_REQUEST),
    
    // Appointment Update
    APPOINTMENT_NOT_FOUND(1031, "Lịch hẹn không tồn tại", HttpStatus.NOT_FOUND),
    SERVICE_NOT_FOUND(1032, "Dịch vụ không tồn tại", HttpStatus.NOT_FOUND),
    ACCESS_DENIED(1033, "Không có quyền truy cập", HttpStatus.FORBIDDEN),

    ID_NOT_NULL(1034, "ID không được để trống", HttpStatus.BAD_REQUEST),

    ALREADY_CANCELED(1035, "Cuộc hẹn đã được xóa", HttpStatus.BAD_REQUEST),
    ALREADY_COMPLETED(1036, "Cuộc hẹn đã hoàn thành", HttpStatus.BAD_REQUEST ),
    UNAUTHENTICATED_CANCEL(1037, "Không có quyền xóa", HttpStatus.BAD_REQUEST),



    //Category
    CATEGORY_NAME_IS_NOT_NULL(1038,"Tên danh mục không được để trống",HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_FOUND(1039,"Không tìm thấy danh mục",HttpStatus.BAD_REQUEST),
    CATEGORY_IS_EXISTED(1040,"Danh mục đã tồn tại",HttpStatus.BAD_REQUEST),




    //Feature and Deleted
    IS_DELETED_VALID (1041,"isDeleted must be 0 or 1",HttpStatus.BAD_REQUEST),
    IS_FEATURED_VALID (1042,"isFeatured must be 0 or 1",HttpStatus.BAD_REQUEST);



    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
