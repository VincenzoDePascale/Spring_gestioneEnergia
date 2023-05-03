package com.epicbe.gestioneenergia.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Fattura;

public interface FatturaRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {

	public Fattura findByNumero(Integer numero);
	public Boolean existsByNumero(Integer numero);
	public Fattura findByAnno(Integer anno);
	List<Fattura> findByAnnoList(Integer anno);
	public Boolean existsByAnno(Integer anno);
	Page<Fattura> findByNumero(Integer numero, Pageable page);
	Page<Fattura> findByAnno(Integer anno, Pageable page);
}
