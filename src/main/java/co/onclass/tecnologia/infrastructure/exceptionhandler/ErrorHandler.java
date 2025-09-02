package co.onclass.tecnologia.infrastructure.exceptionhandler;

import co.onclass.tecnologia.application.exception.DataNotFoundException;
import co.onclass.tecnologia.application.exception.DuplicateDataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex, ServerHttpRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ExceptionHandlerMessages.UNKNOWN_ERROR.getMessage(), request.getPath().toString()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgument(IllegalArgumentException ex, ServerHttpRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ExceptionHandlerMessages.PARAMETER_IS_INVALID.getMessage(), request.getPath().toString()));
    }

    @ExceptionHandler(DuplicateDataException.class)
    public ResponseEntity<ErrorMessage> handleDuplicate(DuplicateDataException ex, ServerHttpRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ExceptionHandlerMessages.DATA_ALREADY_EXISTS.getMessage(), request.getPath().toString()));
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValid(WebExchangeBindException ex, ServerHttpRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getField() + ": " + e.getDefaultMessage()).collect(Collectors.joining(","));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ExceptionHandlerMessages.INVALID_FIELDS.getMessage().concat(message), request.getPath().toString()));
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDataNotFound(DataNotFoundException ex, ServerHttpRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(HttpStatus.NOT_FOUND.value(), ExceptionHandlerMessages.DATA_NOT_FOUND.getMessage(), request.getPath().toString()));
    }
}
