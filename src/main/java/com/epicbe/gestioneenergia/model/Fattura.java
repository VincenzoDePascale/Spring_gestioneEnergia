package com.epicbe.gestioneenergia.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fatture")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Fattura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer anno;
	
	@Column(nullable = false)
	private Date data;
	
	@Column(nullable = false)
	private BigDecimal importo;
	
	@Column(nullable = false, unique = true)
	private Integer numero;
	
	@ManyToOne
	@JsonIgnoreProperties({"fatture"})
	private Cliente cliente;

}
