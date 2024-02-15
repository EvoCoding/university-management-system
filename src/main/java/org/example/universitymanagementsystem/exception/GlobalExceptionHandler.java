package org.example.universitymanagementsystem.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException notFoundException, HttpServletRequest httpServletRequest){
        var errorDTO=ErrorDTO.builder().message(notFoundException.getMessage()).build();
        return new ResponseEntity<>(errorDTO,HttpStatus.NOT_FOUND);
    }
}
