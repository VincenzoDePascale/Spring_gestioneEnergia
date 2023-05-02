package com.epicbe.gestioneenergia.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicbe.gestioneenergia.model.Indirizzo;
import com.epicbe.gestioneenergia.service.IndirizzoService;

@RestController
public class IndirizzoController {
	
@Autowired IndirizzoService indirizzoService;
	
	@GetMapping
	public ResponseEntity<List<Indirizzo>> getAllPageable(List<?> indirizzo) {
		return new ResponseEntity<List<Indirizzo>>(indirizzoService.getAllIndirizzi(), HttpStatus.OK);
	}
	
	/*put, post delete*/

}
