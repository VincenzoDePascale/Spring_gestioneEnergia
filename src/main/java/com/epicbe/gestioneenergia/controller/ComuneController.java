package com.epicbe.gestioneenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/comuni")
public class ComuneController {
	
	@Autowired
	ComuneService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Comune>>(service.getAllComuni(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return new ResponseEntity<Comune>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("/codiceComune/{codiceComune}")
	public ResponseEntity<?> getByCodiceComune(@PathVariable Long codiceComune) {
		return new ResponseEntity<Comune>(HttpStatus.OK);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<?> getByNome(@PathVariable String nome) {
		return new ResponseEntity<Comune>(service.findByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/codiceprov/{codiceProvincia}")
	public ResponseEntity<?> getByCodiceProvincia(@PathVariable Long codiceProvincia) {
		return new ResponseEntity<List<Comune>>(service.findByCodiceProvincia(codiceProvincia), HttpStatus.OK);
	}
	
	@GetMapping("/prov/{provincia}")
	public ResponseEntity<?> getByProvincia(@PathVariable String provincia) {
		return new ResponseEntity<List<Comune>>(service.findByProvincia(provincia), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> postNewComune(@RequestBody Comune c) {
		return new ResponseEntity<>(service.saveComune(c), HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deleteComune(@PathVariable Long id) {
		return new ResponseEntity<String>(service.removeComune(id), HttpStatus.OK);
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<?> updateComune(@PathVariable Comune comune) {
		return new ResponseEntity<Comune>(service.updateComune(comune), HttpStatus.OK);
	}

}
