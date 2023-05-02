package com.epicbe.gestioneenergia.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Comune;
import com.epicbe.gestioneenergia.model.Indirizzo;


public interface IndirizzoRepository extends CrudRepository<Indirizzo, Long>, PagingAndSortingRepository<Indirizzo, Long> {
	
	
	public int findByCap(int cap);
	public Cliente findByCliente(Cliente cliente);
	public Comune findByComune(Comune comune);	
	
	public boolean existsByCivico(String civico);
	public boolean existsById(Long id);
	
	
	
	 
	
	
	
	
	
	
}
