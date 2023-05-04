package com.epicbe.gestioneenergia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Comune;


public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
	
	public boolean existsByEmail(String email);
	
//	public List <Cliente> findByFatturatoAnnuo(Double fatturatAnnuale);
//	
//	public List <Cliente> findByDataInserimento(LocalDate dataInserimento);
//	
//	public List <Cliente> findByDataUltimo(LocalDate dataInserimento);
	
	//public List <Cliente> findByName(String name);
	
	@Query(value="SELECT c FROM Cliente c ORDER BY RAND() LIMIT 1")
	Cliente findByClienteRandom();
	
}
