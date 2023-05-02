package com.epicbe.gestioneenergia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.repository.ComuneRepository;

@Service
public class ComuneService {
	
	@Autowired
	ComuneRepository comuneRepo;
	
	public List<Comune> getAllComuni() {
		return (List<Comune>) comuneRepo.findAll();
	}	
	
	public Page<Comune> getAllComuni(Pageable pageable) {
		return (Page<Comune>) comuneRepo.findAll(pageable);
	}
	
	
	public List<Comune> findByCodProvincia(Long codiceProvincia){
		return (List<Comune>) comuneRepo.findByCodProvincia(codiceProvincia);
	}	
	
	public Page<Comune> findByCodProvincia(Long codiceProvincia, Pageable pageable) {
		return (Page<Comune>) comuneRepo.findByCodProvincia(codiceProvincia, pageable);
	}
	
	public Comune findByNome(String nome) {
		return comuneRepo.findByNome(nome);
	}
	
	public Page<Comune> findByName(String nome, Pageable pageable) {
		return (Page<Comune>) comuneRepo.findByNome(nome, pageable);
	}
	

	public Optional<Comune> getByCodiceComune(Long codiceComune) {
		return comuneRepo.findById(codiceComune);
	}
	
	public List<Comune> findByProvincia(String provincia) {
		return comuneRepo.findByPovincia(provincia);
	}

}
