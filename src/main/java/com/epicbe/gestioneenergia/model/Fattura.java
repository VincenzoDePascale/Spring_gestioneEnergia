package com.epicbe.gestioneenergia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private LocalDate data;
	
	@Column(nullable = false)
	private BigDecimal importo;
	
	@Column(nullable = false, unique = true)
	private Integer numero;
	
	@Enumerated(EnumType.STRING)
	private Stato stato;
	
	@ManyToOne
	@JsonIgnoreProperties({"fatture"})
	private Cliente cliente;

}
