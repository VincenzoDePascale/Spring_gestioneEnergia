package com.epicbe.gestioneenergia.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epicbe.gestioneenergia.helper.CSVHelper;
import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.repository.ComuneRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CSVService {
	
  @Autowired ComuneRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Comune> comuni = CSVHelper.csvToTutorials(file);
     // repository.saveAll(comuni);
    } catch (Exception e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

}