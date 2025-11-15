package com.wings.product.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T>{
    private String status ;
    private String message ;
    private T data ;
    private int httpStatus ;
    private Instant timeStamp ;

    // Success response
    public static <T> ApiResponse<T> success(int httpStatus,T data, String message ) {
        return ApiResponse.<T>builder()
                .httpStatus(httpStatus)
                .status("success")
                .timeStamp(Instant.now())
                .message(message)
                .data(data)
                .build();
    }

    // Overload: default success message
    public static <T> ApiResponse<T> success(T data) {
        return success(200,data, "Operation successful" );
    }

    // Error response
    public static <T> ApiResponse<T> error(String message,int httpStatus) {
        return ApiResponse.<T>builder()
                .httpStatus(httpStatus)
                .status("error")
                .timeStamp(Instant.now())
                .message(message)
                .data(null)
                .build();
    }
}
