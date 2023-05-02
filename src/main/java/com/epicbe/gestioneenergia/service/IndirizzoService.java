package com.epicbe.gestioneenergia.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.epicbe.gestioneenergia.model.Indirizzo;
import com.epicbe.gestioneenergia.repository.IndirizzoRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class IndirizzoService {

	
	@Autowired IndirizzoRepository repo;


	public List<Indirizzo> getAllIndirizzi() {
		return (List<Indirizzo>) repo.findAll();
	}
	
	
	
	public Indirizzo getIndirizzo(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Indirizzo non esiste!!!");
		}
		return repo.findById(id).get();
	}
	
	public Indirizzo createIndirizzo(Indirizzo indirizzo) {		
			repo.save(indirizzo);		
			return indirizzo;
	}
	
	public String removeIndirizzo(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Indirizzo non esiste!!!");
		}
		repo.deleteById(id);
		return "Indirizzo cancellato!!!";
	}
	
	public Indirizzo updateIndirizzo(Indirizzo indirizzo) {
		if(!repo.existsById(indirizzo.getId())) {
			throw new EntityExistsException("Indirizzo non esiste!!!");
		}
		repo.save(indirizzo);
		return indirizzo;
	}
	
}
