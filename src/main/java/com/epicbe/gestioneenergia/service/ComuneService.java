package com.epicbe.gestioneenergia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
	
	public Comune findById(Long id) {
		return comuneRepo.findById(id).get();
	}
	
	public List<Comune> findByCodiceProvincia(Long codiceProvincia){
		return (List<Comune>) comuneRepo.findByCodiceProvincia(codiceProvincia);
	}	
	
	public Page<Comune> findByCodiceProvincia(Long codiceProvincia, Pageable pageable) {
		return (Page<Comune>) comuneRepo.findByCodiceProvincia(codiceProvincia, pageable);
	}
	
	public Comune findByNome(String nome) {
		return comuneRepo.findByNome(nome);
	}
	
	public Page<Comune> findByName(String nome, Pageable pageable) {
		return (Page<Comune>) comuneRepo.findByNome(nome, pageable);
	}
	

	public Comune getByCodiceComune(Long codiceComune) {
		return comuneRepo.findByCodiceComune(codiceComune);
	}
	
	public List<Comune> findByProvincia(String provincia) {
		return comuneRepo.findByProvincia(provincia);
	}
	
	public Comune saveComune(Comune c) {
		comuneRepo.save(c);
		return c;
	}
	
	public String removeComune(Long id) {
		comuneRepo.deleteById(id);
		return "Comune eliminato correttamente";
	}
	
	public Comune updateComune(Comune comune) {
		comuneRepo.save(comune);
		return comune;
	}

}
