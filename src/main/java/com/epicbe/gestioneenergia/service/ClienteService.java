package com.epicbe.gestioneenergia.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.repository.ClienteRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	@Autowired ClienteRepository repo;
	@Autowired @Qualifier("ClienteRandom") private ObjectProvider <Cliente> randomClienteProvider;
	
	// Per creare cliente
	
	public void createClienteRandom() {		
	 createCliente(randomClienteProvider.getObject());
	}
	
	//Metodi per API
	
	public List<Cliente> getAllCliente() {
		return (List<Cliente>) repo.findAll();
	}
	
	public Page<Cliente> getAllClientePageable(Pageable pageable) {
		return (Page<Cliente>) repo.findAll(pageable);
	}
	
	// clienti filtrati per data di inizio inserimento
	public List <Cliente> getClientiPerDataInserimento(LocalDate dataInserimento) {
		if(!repo.existsByInserimento(dataInserimento)) {
			throw new EntityNotFoundException("Non esistono clienti con la data d'inserimento indicata!");
		}
		return repo.findByInserimento(dataInserimento);
	}
	
	// clienti filtrati per data di fine contatto
		public List <Cliente> getClientiPerUltimoContatto(LocalDate dataUltimo) {
			if(!repo.existsByUltimocontatto(dataUltimo)) {
				throw new EntityNotFoundException("Non esistono clienti con la data dell'ultimo inserimento indicata!");
			}
			return repo.findByUltimocontatto(dataUltimo);
		}
	
	//clienti filtrati per parte del nome
	public List<Cliente> getAllClientiByName(String name){
		return (List<Cliente>) repo.searchByPartName(name);
	}
	
	public List<Cliente> getClienteByProvincia(String name){
		return (List<Cliente>) repo.searchByProvincia(name);
	}
	
	public Cliente getCliente(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Cliente not exists!!!");
		}
		return repo.findById(id).get();
	}
	
	public Cliente getClienteRandom() {
		return repo.findByClienteRandom();
	}
	
	public Cliente createCliente(Cliente Cliente) {
		if(repo.existsByEmail(Cliente.getEmail())) {
			throw new EntityExistsException("Partita iva exists!!!");
		} else {
			repo.save(Cliente);
		}		
		return Cliente;
	}
	
	public String removeCliente(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		repo.deleteById(id);
		return "Cliente Deleted!!!";
	}
	
	public Cliente updateCliente(Cliente Cliente) {
		if(!repo.existsById(Cliente.getId())) {
			throw new EntityExistsException("Cliente not exists!!!");
		}
		repo.save(Cliente);
		return Cliente;
	}
		
}
