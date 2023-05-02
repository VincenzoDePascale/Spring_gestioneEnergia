package com.epicbe.gestioneenergia.service;

import java.util.List;

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
	
	public List<Comune> findByCodProvincia(Long codiceProvincia){
		return (List<Comune>) comuneRepo.findByCodProvincia(codiceProvincia);
	}
	
	public Comune findByNome(String nome) {
		return (Comune) comuneRepo.findByNome(nome);
	}
	
	public Page<Comune> getAllComuniPageable(Pageable pageable) {
		return (Page<Comune>) comuneRepo.findAll(pageable);
	}

}
