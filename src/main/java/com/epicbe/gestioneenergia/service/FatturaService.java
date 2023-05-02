package com.epicbe.gestioneenergia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicbe.gestioneenergia.model.Fattura;
import com.epicbe.gestioneenergia.repository.FatturaRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService {
	
	@Autowired FatturaRepository repo;
	
	public List<Fattura> getAllFatture() {
		return (List<Fattura>) repo.findAll();
	}
	
	public Page<Fattura> getAllFatturePag(Pageable pag) {
		return (Page<Fattura>) repo.findAll(pag);
	}
	
	public Fattura getFattura(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Questa fattura non esiste!");
		}
		return repo.findById(id).get();
	}
	public Fattura getFatturaPerNumero(Integer numero) {
		if(!repo.existByNumero(numero)) {
			throw new EntityNotFoundException("Questa fattura non esiste!");
		}
		return repo.findByNumero(numero);
	}
	
	public Fattura getFatturaPerAnno(Integer anno) {
		if(!repo.existByAnno(anno)) {
			throw new EntityNotFoundException("Non esistono fatture per questo anno!");
		}
		return repo.findByAnno(anno);
	}
	
	public Fattura creaFattura(Fattura fattura) {
		if(!repo.existByNumero(fattura.getNumero())) {
			throw new EntityExistsException("La fattura con " + fattura.getNumero() + " è già stata creata!");
		} else {
		repo.save(fattura);
		}
		return fattura;
	}
	
	public String removeFattura(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Questa fattura non esiste!");
		}
		repo.deleteById(id);
		return "Fattura cancellata!";
	}
	
	public Fattura updateFattura(Fattura fattura) {
		if(!repo.existsById(fattura.getId())) {
			throw new EntityExistsException("Questa fattura non esiste!");
		}
		repo.save(fattura);
		return fattura;
	}

}
