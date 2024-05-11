package com.softbrasinovacoes.logisticsmanager.infra;

import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class RequestsExceptionHandler {
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> threat404(Error e) {
    Map<String, String> map = Map.of("error", e.getMessage());
    return ResponseEntity.status(404).body(map);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> threatConstraintViolation(Error e) {
    Map<String, String> map = Map.of("error", e.getMessage());
    return ResponseEntity.badRequest().body(map);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> threatRunTime(Error e) {
    Map<String, String> map = Map.of("error", e.getMessage());
    return ResponseEntity.internalServerError().body(map);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<?> threatDataIntegrtionValidation(Error e) {
    Map<String, String> map = Map.of("error", e.getMessage());
    return ResponseEntity.badRequest().body(map);
  }
}
