package com.epicbe.gestioneenergia.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epicbe.gestioneenergia.model.Indirizzo;
import com.epicbe.gestioneenergia.service.IndirizzoService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController("/api/indirizzi")
public class IndirizzoController {
	
@Autowired IndirizzoService service;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Indirizzo>> getAllPageable(List<?> indirizzo) {
		return new ResponseEntity<List<Indirizzo>>(service.getAllIndirizzi(), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createIndirizzo(@RequestBody Indirizzo indirizzo) {
		return new ResponseEntity<Indirizzo>(service.createIndirizzo(indirizzo), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteIndirizzo(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeIndirizzo(id), HttpStatus.OK);
	}
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateIndirizzo(@RequestBody Indirizzo indirizzo) {
		return new ResponseEntity<Indirizzo>(service.updateIndirizzo(indirizzo), HttpStatus.CREATED);
	}
	
	/*put, post delete*/

}
