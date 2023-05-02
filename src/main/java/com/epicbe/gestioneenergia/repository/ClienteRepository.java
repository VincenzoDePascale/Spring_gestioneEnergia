package com.epicbe.gestioneenergia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {

	public List <Cliente> findByFatturatoAnnuo(Double fatturatAnnuale);
	
	public List <Cliente> findByDataInserimento(LocalDate dataInserimento);
	
	public List <Cliente> findByDataUltimo(LocalDate dataInserimento);
	
	//public List <Cliente> findByName(String name);
	
}
