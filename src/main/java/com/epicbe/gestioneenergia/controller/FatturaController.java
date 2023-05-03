package com.epicbe.gestioneenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicbe.gestioneenergia.model.Fattura;
import com.epicbe.gestioneenergia.service.FatturaService;




@RestController
@RequestMapping("/api")
public class FatturaController {
	
	@Autowired FatturaService service;
	
	@GetMapping("/fatture")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Fattura>>(service.getAllFatture(), HttpStatus.OK);
	}
	@GetMapping("/fatture/numero/{numero}")
	public ResponseEntity<?> getFatturePerNumero(@PathVariable Integer numero){
		return new ResponseEntity<Fattura>(service.getFatturaPerNumero(numero), HttpStatus.OK);
	}
	@GetMapping("/fatture/anno/{anno}")
	public ResponseEntity<?> getFatturePerAnno(@PathVariable Integer anno){
		return new ResponseEntity<Fattura>(service.getFatturaPerAnno(anno), HttpStatus.OK);
	}
	
	@GetMapping("/fatture/pageable")
	public ResponseEntity<Page<Fattura>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Fattura>>(service.getAllFatturePag(pag), HttpStatus.OK);
	}
	
	@PostMapping("/fatture")
	public ResponseEntity<?> createFattura(@RequestBody Fattura fattura) {
		return new ResponseEntity<Fattura>(service.creaFattura(fattura), HttpStatus.CREATED);
	}
	@DeleteMapping("/fatture/{id}")
	public ResponseEntity<String> deleteFattura(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeFattura(id), HttpStatus.OK);
	}
	@PutMapping("/fatture")
	public ResponseEntity<?> updateUser(@RequestBody Fattura fattura) {
		return new ResponseEntity<Fattura>(service.updateFattura(fattura), HttpStatus.CREATED);
	}
	

}
