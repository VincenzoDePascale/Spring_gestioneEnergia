package com.epicbe.gestioneenergia.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Comune;


public interface ClienteRepository extends CrudRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {
	
	public boolean existsByEmail(String email);
	public boolean existsByInserimento(LocalDate inserimento);
	public boolean existsByUltimocontatto(LocalDate dataUltimo);
	
	@Query("SELECT c FROM Cliente c JOIN Fattura f ON c.id = f.cliente_id GROUP BY YEAR(f.data) = :anno")
    List<Cliente> filtraClientiPerFatturatoAnnua(
        @Param("anno") int anno
    );
	
//	public List <Cliente> findByFatturatoAnnuo(BigDecimal fatturatoAnnuo);
	
	public List <Cliente> findByInserimento(LocalDate dataInserimento);
	
	@Query(value="SELECT c FROM Cliente c ORDER BY RANDOM() LIMIT 1")
	Cliente findByClienteRandom();
	
	public List <Cliente> findByUltimocontatto(LocalDate dataUltimo);
	
	@Query("SELECT c FROM Cliente c WHERE LOWER(c.nomeContatto) LIKE LOWER('%' || :name || '%')")
	public List<Cliente> searchByPartName(String name);
}
