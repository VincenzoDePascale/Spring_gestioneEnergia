package com.epicbe.gestioneenergia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Comune;

public interface ComuneRepository 
extends CrudRepository<Comune, Long>, PagingAndSortingRepository<Comune, Long> {

	Page<Comune> findByCodProvinciaPage(Long codiceProvincia, Pageable pageable);
	Page<Comune> findByNomePage(String nome, Pageable pageable);
	Page<Comune> findByProvinciaPage(String provincia, Pageable pageable);
	List<Comune> findByCodProvincia(Long codiceProvincia);
	Comune findByNome(String nome);

}
