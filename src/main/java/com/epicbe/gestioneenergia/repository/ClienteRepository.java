package com.epicbe.gestioneenergia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Cliente;


public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
	
	public boolean existsByEmail(String email);
	public boolean existsByInserimento(LocalDate inserimento);
	public boolean existsByUltimocontatto(LocalDate dataUltimo);
	
//	public List <Cliente> findByFatturatoAnnuo(Double fatturatAnnuale);
	
	public List <Cliente> findByInserimento(LocalDate dataInserimento);
	
	public List <Cliente> findByUltimocontatto(LocalDate dataUltimo);
	
	@Query("SELECT c FROM Cliente c WHERE LOWER(c.nomeContatto) LIKE LOWER('%' || :name || '%')")
	public List<Cliente> searchByPartName(String name);
}
