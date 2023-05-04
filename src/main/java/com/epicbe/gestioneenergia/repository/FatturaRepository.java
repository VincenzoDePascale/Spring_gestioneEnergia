package com.epicbe.gestioneenergia.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Fattura;
import com.epicbe.gestioneenergia.model.Stato;

public interface FatturaRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {

	public Fattura findByNumero(Integer numero);
	public Boolean existsByNumero(Integer numero);
	public Fattura findByAnno(Integer anno);
	public Boolean existsByAnno(Integer anno);
	
	@Query("SELECT DISTINCT SUM(f.importo) as fatturato, c FROM Fattura f LEFT JOIN Cliente c ON f.cliente = c.id WHERE YEAR(f.data) = :anno GROUP BY c")
	List<Object> calcolaFatturatoAnnuo(@Param("anno") int anno);
	
	public List<Fattura> findByCliente(Cliente c);
	
	public Page<Fattura> findByStato(Stato stato, Pageable pageable);
	
	public Page<Fattura> findByData(LocalDate data, Pageable pageable);
}
