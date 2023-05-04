package com.epicbe.gestioneenergia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Fattura;

public interface FatturaRepository extends CrudRepository<Fattura, Long>, PagingAndSortingRepository<Fattura, Long> {

	public Fattura findByNumero(Integer numero);
	public Boolean existsByNumero(Integer numero);
	public Fattura findByAnno(Integer anno);
	public Boolean existsByAnno(Integer anno);
//	@Query("SELECT SUM(f.importo) FROM Fattura f WHERE YEAR(f.data) = :anno")
//	BigDecimal calcolaFatturatoAnnuo(@Param("anno") int anno);
	
}
