package com.epicbe.gestioneenergia.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Fattura;
import com.epicbe.gestioneenergia.model.Stato;
import com.epicbe.gestioneenergia.repository.ClienteRepository;
import com.epicbe.gestioneenergia.repository.FatturaRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class FatturaService {
	
	@Autowired FatturaRepository repo;
	//@Autowired ClienteRepository repoCliente;
	@Autowired ClienteService servCliente;
	
	@Autowired @Qualifier("CreaFatturaFake") private ObjectProvider <Fattura> randomFattureProvider;
	
	public List<Fattura> getAllFatture() {
		return (List<Fattura>) repo.findAll();
	}
	
	public Page<Fattura> getAllFatturePag(Pageable pag) {
		return (Page<Fattura>) repo.findAll(pag);
	}
	
	public Fattura getFattura(Long id) {
		if(repo.existsById(id)) {
			throw new EntityNotFoundException("Questa fattura non esiste!");
		}
		return repo.findById(id).get();
	}
	public Fattura getFatturaPerNumero(Integer numero) {
		if(repo.existsByNumero(numero)) {
			throw new EntityNotFoundException("Questa fattura non esiste!");
		}
		return repo.findByNumero(numero);
	}
	
	public Fattura getFatturaPerAnno(Integer anno) {
		if(repo.existsByAnno(anno)) {
			throw new EntityNotFoundException("Non esistono fatture per questo anno!");
		}
		return repo.findByAnno(anno);
	}
	
	public Fattura creaFattura(Fattura fattura) {
		if(repo.existsByNumero(fattura.getNumero())) {
			throw new EntityExistsException("La fattura con " + fattura.getNumero() + " è già stata creata!");
		} else {
		repo.save(fattura);
		}
		return fattura;
	}
	
	public void creaFatturaFake() {
		// createCliente(randomClienteProvider.getObject());
		creaFattura(randomFattureProvider.getObject());
	}
	
	public String removeFattura(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Questa fattura non esiste!");
		}
		repo.deleteById(id);
		return "Fattura cancellata!";
	}
	
	public Fattura updateFattura(Fattura fattura) {
		if(repo.existsById(fattura.getId())) {
			throw new EntityExistsException("Questa fattura non esiste!");
		}
		repo.save(fattura);
		return fattura;
	}
	
	   public List<Object> calcolaFatturatoAnnuo(int anno) {
	        return repo.calcolaFatturatoAnnuo(anno);
	    }
	   
	   public List<Fattura> listatoByCliente(Long id) {
		   //cercare il cliente tramite repocliente e id
		   Cliente c = servCliente.getCliente(id);
		 return repo.findByCliente(c);		 
	   }
	   
	   public Page<Fattura> filtraPerStato(Stato stato, Pageable pageable){
		   return repo.findByStato(stato, pageable);
	   }
	   
	   public Page<Fattura> filtraPerData(LocalDate data, Pageable pageable){
		   return repo.findByData(data, pageable);
	   }

}
