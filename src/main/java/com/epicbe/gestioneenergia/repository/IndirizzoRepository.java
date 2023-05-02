package com.epicbe.gestioneenergia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Indirizzo;

public interface IndirizzoRepository extends CrudRepository<Indirizzo, Long>, PagingAndSortingRepository<Indirizzo, Long> {

}
