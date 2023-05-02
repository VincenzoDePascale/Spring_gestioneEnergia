package com.epicbe.gestioneenergia.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="indirizzi")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Indirizzo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String via;
	
	@Column(nullable = false)
	private String civico;
	
	@ManyToOne
	@JoinColumn(name = "comune_id", nullable = false)
	private Comune comune;
	
	@Column(nullable = false)
	private int cap;
	
	@ManyToOne
	@JsonIgnoreProperties({"clienti"})
	private Cliente cliente;
}
