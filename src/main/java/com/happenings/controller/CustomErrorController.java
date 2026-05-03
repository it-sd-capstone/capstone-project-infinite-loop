package com.happenings.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.error.ErrorController;
import com.happenings.exceptions.ErrorResponse;



@RestController
public class CustomErrorController implements ErrorController {

  @RequestMapping("/error")
  public ResponseEntity<ErrorResponse> handleError(HttpServletRequest request) {

    Object statusObj = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    int status = statusObj != null ? Integer.parseInt(statusObj.toString()) : 500;

    ErrorResponse error = new ErrorResponse(
            status,
            HttpStatus.valueOf(status).getReasonPhrase(),
            "Unauthorized access",
            request.getRequestURI()
    );

    return ResponseEntity.status(status).body(error);
  }
}
