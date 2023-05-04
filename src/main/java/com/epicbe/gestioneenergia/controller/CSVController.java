package com.epicbe.gestioneenergia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epicbe.gestioneenergia.helper.CSVHelper;
import com.epicbe.gestioneenergia.service.CSVService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins =  "*", maxAge = 360000)
@Controller
@RequestMapping("/api/csv")
@Slf4j
public class CSVController {

  @Autowired
  CSVService fileService;

  @PostMapping("/comuni")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";

    if (CSVHelper.hasCSVFormat(file)) {
      try {
        fileService.save(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(new String("uplode complete"));
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new String("uplode failed"));
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String("no csv"));
  }

  

}