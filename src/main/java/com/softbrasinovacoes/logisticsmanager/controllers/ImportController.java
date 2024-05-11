package com.softbrasinovacoes.logisticsmanager.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.softbrasinovacoes.logisticsmanager.services.imports.ImportXmlNfeService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/imports")
@AllArgsConstructor
public class ImportController {
  private final ImportXmlNfeService importXmlNfeService;
  
  @PostMapping("/nfe/xml")
  @Transactional
  public ResponseEntity<?> uploadXmlNfe(@RequestParam("file") MultipartFile file) {
    importXmlNfeService.execute(file);

    Map<String, String> response = Map.of("message", "File importated with Success to database.");
    return ResponseEntity.ok().body(response);
  }
}
