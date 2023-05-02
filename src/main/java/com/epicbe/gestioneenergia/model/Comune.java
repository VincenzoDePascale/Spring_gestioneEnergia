package com.epicbe.gestioneenergia.model;

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
@Table(name="comuni")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comune {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codiceComune;
	
	@Column(nullable = false)
	private Long codiceProvincia;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String provincia;

	public Comune(Long codiceProvincia, String nome, String provincia) {
		super();
		this.codiceProvincia = codiceProvincia;
		this.nome = nome;
		this.provincia = provincia;
	}
	
}
