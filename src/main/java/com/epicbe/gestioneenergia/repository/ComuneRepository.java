package com.epicbe.gestioneenergia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Comune;

public interface ComuneRepository 
extends CrudRepository<Comune, Long>, PagingAndSortingRepository<Comune, Long> {

	Page<Comune> findByCodiceProvincia(Long codiceProvincia, Pageable pageable);
	Page<Comune> findByNome(String nome, Pageable pageable);
	Page<Comune> findByProvincia(String provincia, Pageable pageable);
	List<Comune> findByCodiceProvincia(Long codiceProvincia);
	Comune findByNome(String nome);
	List<Comune> findByProvincia(String provincia);
	
	@Query(value="SELECT c FROM Comune c ORDER BY RANDOM() LIMIT 1")
	Comune findByComuneRandom();
	

}
