package com.epicbe.gestioneenergia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Fattura;

public interface FatturaRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {

}
