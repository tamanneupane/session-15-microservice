package com.vastika.doctorservice.controlleradvice;

import com.vastika.doctorservice.exceptions.DoctorNotFoundException;
import com.vastika.doctorservice.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDoctorNotFoundException(DoctorNotFoundException ex){
        log.info("Controller advice called");
        ErrorResponse response = ErrorResponse.builder()
                .message(ex.getLocalizedMessage())
                .status("ERROR")
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDataDeleteException(EmptyResultDataAccessException ex){
        log.info("Controller advice called");
        ErrorResponse response = ErrorResponse.builder()
                .message("The data you are trying to delete is not found")
                .status("ERROR")
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleDataValidationException(MethodArgumentNotValidException ex){
        log.info("Controller advice called");
        ErrorResponse response = ErrorResponse.builder()
                .message("Validation error")
                .status("ERROR")
                .localDateTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleDoctorNotFoundException(Exception ex){
//        log.info("Controller advice called");
//        return new ResponseEntity<>("Generic Error", HttpStatus.NOT_FOUND);
//    }
}
