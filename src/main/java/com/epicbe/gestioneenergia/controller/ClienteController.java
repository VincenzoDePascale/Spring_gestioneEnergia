package com.epicbe.gestioneenergia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.service.ClienteService;
import com.epicbe.gestioneenergia.service.FatturaService;

@CrossOrigin(origins =  "*", maxAge = 360000)
@RestController
@RequestMapping("/api/clienti")
public class ClienteController {

	@Autowired ClienteService service;
	@Autowired FatturaService fatService;
	
	@GetMapping
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Cliente>>(service.getAllCliente(), HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getCliente(id), HttpStatus.OK);
	}
	
	@GetMapping("/inserimento/{data}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerNumero(@PathVariable LocalDate data){
		return new ResponseEntity<List<Cliente>>(service.getClientiPerDataInserimento(data), HttpStatus.OK);
	}
	
	@GetMapping("/ultimo/contatto/{data}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getClientiPerUltimoInserimento(@PathVariable LocalDate data){
		return new ResponseEntity<List<Cliente>>(service.getClientiPerUltimoContatto(data), HttpStatus.OK);
	}
	
	@GetMapping("/fatturatoannuo/{anno}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerFatturatoAnno(@PathVariable int anno){
		return new ResponseEntity<List<Cliente>>(fatService.calcolaFatturatoAnnuo(anno), HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Page<Cliente>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Cliente>>(service.getAllClientePageable(pag), HttpStatus.OK);
	}
	
	@GetMapping("/partenome/{nome}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getclientiPerNomeParte(@PathVariable("nome") String nome){
		return new ResponseEntity<>(service.getAllClientiByName(nome), HttpStatus.OK);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createCliente(@RequestBody Cliente Cliente) {
		return new ResponseEntity<Cliente>(service.createCliente(Cliente), HttpStatus.CREATED);
	}
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeCliente(id), HttpStatus.OK);
	}
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Cliente Cliente) {
		return new ResponseEntity<Cliente>(service.updateCliente(Cliente), HttpStatus.CREATED);
	}
	
}
