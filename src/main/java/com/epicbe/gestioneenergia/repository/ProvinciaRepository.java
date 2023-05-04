package com.epicbe.gestioneenergia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Provincia;

public interface ProvinciaRepository extends CrudRepository<Provincia, Long>, PagingAndSortingRepository<Provincia, Long> {

}
