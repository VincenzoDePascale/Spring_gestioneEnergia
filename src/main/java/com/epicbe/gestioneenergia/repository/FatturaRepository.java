package com.epicbe.gestioneenergia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Fattura;

public interface FatturaRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {

	public Fattura findByNumero(Integer numero);
	public Boolean existByNumero(Integer numero);
	public Fattura findByAnno(Integer anno);
	public Boolean existByAnno(Integer anno);
}
