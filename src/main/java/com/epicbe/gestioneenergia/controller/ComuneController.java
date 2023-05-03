package com.epicbe.gestioneenergia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.service.ComuneService;

@RestController
@RequestMapping("/api")
public class ComuneController {
	
	@Autowired
	ComuneService service;
	
	@GetMapping("/comuni/all")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Comune>>(service.getAllComuni(), HttpStatus.OK);
	}
	
	@GetMapping("/comuni/id/{codiceComune}")
	public ResponseEntity<?> getByCodiceComune(@PathVariable Long codiceComune) {
		return new ResponseEntity<Comune>(HttpStatus.OK);
	}
	
	@GetMapping("/comuni/nome/{nome}")
	public ResponseEntity<?> getByNome(@PathVariable String nome) {
		return new ResponseEntity<Comune>(service.findByNome(nome), HttpStatus.OK);
	}
	
	@GetMapping("/comuni/idprov/{codiceProvincia}")
	public ResponseEntity<?> getByCodiceProvincia(@PathVariable Long codiceProvincia) {
		return new ResponseEntity<List<Comune>>(service.findByCodiceProvincia(codiceProvincia), HttpStatus.OK);
	}
	
	@GetMapping("/comuni/prov/{codiceProvincia}")
	public ResponseEntity<?> getByProvincia(@PathVariable String provincia) {
		return new ResponseEntity<List<Comune>>(service.findByProvincia(provincia), HttpStatus.OK);
	}

}
