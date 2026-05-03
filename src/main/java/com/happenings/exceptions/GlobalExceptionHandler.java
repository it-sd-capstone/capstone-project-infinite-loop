package com.happenings.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import com.happenings.exceptions.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  // ============================
  // 400 - IllegalArgumentException
  // ============================
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleBadRequest(
          IllegalArgumentException ex,
          HttpServletRequest request
  ) {
    ErrorResponse error = new ErrorResponse(
            400,
            "Bad Request",
            ex.getMessage(),
            request.getRequestURI()
    );
    return ResponseEntity.status(400).body(error);
  }

  // ============================
  // 400 - Malformed JSON
  // ============================
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleJsonParseError(
          HttpMessageNotReadableException ex,
          HttpServletRequest request
  ) {
    ErrorResponse error = new ErrorResponse(
            400,
            "Malformed JSON",
            "The request body could not be parsed.",
            request.getRequestURI()
    );
    return ResponseEntity.status(400).body(error);
  }

  // ============================
  // 400 - Validation Errors (@Valid)
  // ============================
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationErrors(
          MethodArgumentNotValidException ex,
          HttpServletRequest request
  ) {
    String message = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(err -> err.getField() + ": " + err.getDefaultMessage())
            .findFirst()
            .orElse("Validation failed");

    ErrorResponse error = new ErrorResponse(
            400,
            "Validation Error",
            message,
            request.getRequestURI()
    );

    return ResponseEntity.status(400).body(error);
  }

  // ============================
// 401 - Unauthorized
// ============================
  @ExceptionHandler(org.springframework.security.access.AccessDeniedException.class)
  public ResponseEntity<ErrorResponse> handleUnauthorized(
          org.springframework.security.access.AccessDeniedException ex,
          HttpServletRequest request
  ) {
    ErrorResponse error = new ErrorResponse(
            401,
            "Unauthorized",
            "You are not authorized to access this resource.",
            request.getRequestURI()
    );

    return ResponseEntity.status(401).body(error);
  }

  // ============================
// 404 - Not Found
// ============================
  @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(
          org.springframework.web.servlet.NoHandlerFoundException ex,
          HttpServletRequest request
  ) {
    ErrorResponse error = new ErrorResponse(
            404,
            "Not Found",
            "The requested resource was not found.",
            request.getRequestURI()
    );

    return ResponseEntity.status(404).body(error);
  }


  // ============================
  // 500 - Catch-all fallback
  // ============================
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(
          Exception ex,
          HttpServletRequest request
  ) {
    ErrorResponse error = new ErrorResponse(
            500,
            "Internal Server Error",
            ex.getMessage(),
            request.getRequestURI()
    );
    return ResponseEntity.status(500).body(error);
  }
}
