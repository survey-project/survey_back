package com.survey.Advice;

import com.survey.DTO.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<Object>> handleException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ResponseDto.builder()
                        .success(false)
                        .status(HttpStatus.NOT_FOUND)
                        .errorMessages(List.of(e.getMessage()))
                        .build()
        );
    }
}
