package com.epicbe.gestioneenergia.model;

import com.epicbe.gestioneenergia.model.Comune.ComuneBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="province")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Provincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String sigla;
	
	@Column(nullable = false)
	private String provincia;
	
	@Column(nullable = false)
	private String regione;

}
