package com.epicbe.gestioneenergia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Comune;

public interface ComuneRepository extends CrudRepository<Comune, Long>, PagingAndSortingRepository<Comune, Long> {

}
