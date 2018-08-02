package au.com.mttqnln.controller;

import au.com.mttqnln.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request) {
    ErrorResponse errorResponse = new ErrorResponse("Request format invalid");
    for (final FieldError error: ex.getBindingResult().getFieldErrors()) {
      errorResponse.addDetails(error.getField() + " field " + error.getDefaultMessage());
    }
    return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
  }
}
