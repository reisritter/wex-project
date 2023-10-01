package com.wex.app.controller.exception;

import com.wex.app.controller.exception.dto.ApiErrors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ApplicationControllerAdvice {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
        public ApiErrors handleValidantionErrors(MethodArgumentNotValidException ex)
        {
            BindingResult bindingResult = ex.getBindingResult();
            List<String> messages = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            return new ApiErrors(messages);
        }

        @ExceptionHandler(WexBusinessException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        public ApiErrors handleValidantionErrors(WexBusinessException ex)
        {
            return new ApiErrors(ex.getMessage());
        }
        @ExceptionHandler(NotFoundException.class)
        @ResponseStatus(value = HttpStatus.NOT_FOUND)
        public ApiErrors handleNotFound(NotFoundException ex)
        {
            return new ApiErrors(ex.getMessage());
        }
}
