package com.wings.product.common;

import com.wings.product.exception.DuplicateProductCodeException;
import com.wings.product.exception.DuplicateProductNameException;
import com.wings.product.exception.ProductListEmptyException;
import com.wings.product.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleProductNotFound(ProductNotFoundException ex) {
        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(ProductListEmptyException.class)
    public ResponseEntity<ApiResponse<?>>  handleProductListEmpty(ProductListEmptyException ex){
        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(),
                HttpStatus.OK.value()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);//204
    }
    @ExceptionHandler(DuplicateProductNameException.class)
    public ResponseEntity<ApiResponse<?>> handleDuplicateProductName(DuplicateProductNameException ex){
        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(),
                HttpStatus.CONFLICT.value() //409
        );
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(response);
    }
    @ExceptionHandler(DuplicateProductCodeException.class)
    public ResponseEntity<ApiResponse<?>> handleDuplicateProductCode(DuplicateProductCodeException ex){
        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(),
                HttpStatus.CONFLICT.value()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(response);
    }
    // Handle any unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralException(Exception ex) {
        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
