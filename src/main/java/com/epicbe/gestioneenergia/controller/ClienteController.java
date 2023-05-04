package com.epicbe.gestioneenergia.controller;

import java.time.LocalDate;
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

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.service.ClienteService;

@RestController
@RequestMapping("/api/")
public class ClienteController {

	@Autowired ClienteService service;
	
	@GetMapping("/clienti")
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Cliente>>(service.getAllCliente(), HttpStatus.OK);
	}
	@GetMapping("/clienti/inserimento/{data}")
	public ResponseEntity<?> getclientiPerNumero(@PathVariable LocalDate data){
		return new ResponseEntity<List<Cliente>>(service.getClientiPerDataInserimento(data), HttpStatus.OK);
	}
	
	@GetMapping("/clienti/ultimo/contatto/{data}")
	public ResponseEntity<?> getClientiPerUltimoInserimento(@PathVariable LocalDate data){
		return new ResponseEntity<List<Cliente>>(service.getClientiPerUltimoContatto(data), HttpStatus.OK);
	}
//	@GetMapping("/clienti/fatturatoannuo/{fatturatoAnnuo}")
//	public ResponseEntity<?> getclientiPerFatturatoAnno(@PathVariable double fatturatoAnnuo){
//		return new ResponseEntity<List<Cliente>>(service.getClientePerFatturatoAnnuo(fatturatoAnnuo), HttpStatus.OK);
//	}
	
	@GetMapping("/clienti/pageable")
	public ResponseEntity<Page<Cliente>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Cliente>>(service.getAllClientePageable(pag), HttpStatus.OK);
	}
	
	@GetMapping("/clienti/partenome/{nome}")
	public ResponseEntity<?> getclientiPerNomeParte(@PathVariable String parteNome){
		return new ResponseEntity <List<Cliente>> (service.getAllClientiByName(parteNome), HttpStatus.OK);
	}
	
	@PostMapping("/clienti")
	public ResponseEntity<?> createCliente(@RequestBody Cliente Cliente) {
		return new ResponseEntity<Cliente>(service.createCliente(Cliente), HttpStatus.CREATED);
	}
	@DeleteMapping("/clienti/{id}")
	public ResponseEntity<String> deleteCliente(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeCliente(id), HttpStatus.OK);
	}
	@PutMapping("/clienti")
	public ResponseEntity<?> updateUser(@RequestBody Cliente Cliente) {
		return new ResponseEntity<Cliente>(service.updateCliente(Cliente), HttpStatus.CREATED);
	}
	
}
