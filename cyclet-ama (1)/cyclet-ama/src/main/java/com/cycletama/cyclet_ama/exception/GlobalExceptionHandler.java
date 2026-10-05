package com.cycletama.cyclet_ama.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleProductNotFound(ProductNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleOrderNotFound(OrderNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ProductModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleProductModelNotFound(OrderNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCategoryNotFound(OrderNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCustomerNotFound(OrderNotFoundException ex) {
        return ex.getMessage();
    }
}
