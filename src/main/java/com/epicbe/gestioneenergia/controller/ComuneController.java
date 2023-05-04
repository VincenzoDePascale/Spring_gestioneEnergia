package com.epicbe.gestioneenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
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

import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.service.ComuneService;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/api")
public class ComuneController {
	
	@Autowired
	ComuneService service;
	
	@GetMapping("/comuni/all")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Comune>>(service.getAllComuni(), HttpStatus.OK);
	}
	
	@GetMapping("comuni/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return new ResponseEntity<Comune>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/comuni/codiceComune/{codiceComune}")
	public ResponseEntity<?> getByCodiceComune(@PathVariable Long codiceComune) {
		return new ResponseEntity<Comune>(HttpStatus.OK);
	}
	
	@GetMapping("/comuni/nome/{nome}")
	public ResponseEntity<?> getByNome(@PathVariable String nome) {
		return new ResponseEntity<Comune>(service.findByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/comuni/codiceprov/{codiceProvincia}")
	public ResponseEntity<?> getByCodiceProvincia(@PathVariable Long codiceProvincia) {
		return new ResponseEntity<List<Comune>>(service.findByCodiceProvincia(codiceProvincia), HttpStatus.OK);
	}
	
	@GetMapping("/comuni/prov/{provincia}")
	public ResponseEntity<?> getByProvincia(@PathVariable String provincia) {
		return new ResponseEntity<List<Comune>>(service.findByProvincia(provincia), HttpStatus.OK);
	}
	
	@PostMapping("/comuni")
	public ResponseEntity<?> postNewComune(@RequestBody Comune c) {
		return new ResponseEntity<>(service.saveComune(c), HttpStatus.OK);
	}
	
	@DeleteMapping("/comuni/{id}")
	public ResponseEntity<?> deleteComune(@PathVariable Long id) {
		return new ResponseEntity<String>(service.removeComune(id), HttpStatus.OK);
	}
	
	@PutMapping("/comuni/{id}")
	public ResponseEntity<?> updateComune(@PathVariable Comune comune) {
		return new ResponseEntity<Comune>(service.updateComune(comune), HttpStatus.OK);
	}

}
