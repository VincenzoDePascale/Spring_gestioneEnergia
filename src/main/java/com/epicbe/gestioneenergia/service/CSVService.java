package com.epicbe.gestioneenergia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.epicbe.gestioneenergia.helper.CSVHelper;
import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.model.Provincia;
import com.epicbe.gestioneenergia.repository.ComuneRepository;
import com.epicbe.gestioneenergia.repository.ProvinciaRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CSVService {
	
	 @Autowired ComuneRepository comunerepo;
	 @Autowired ProvinciaRepository provrepo;

  public void saveComuni(MultipartFile file) {
    try {
      List<Comune> comuni = CSVHelper.csvToComuni(file);
      comunerepo.saveAll(comuni);
      log.info("Aggiornati i comuni sul DB da CSV import");
    } catch (Exception e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  
  public void saveProvince(MultipartFile file) {
	    try {
	      List<Provincia> provs = CSVHelper.csvToProvince(file);
	      provrepo.saveAll(provs);
	      log.info("Aggiornate le province sul DB da CSV import");
	    } catch (Exception e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

}