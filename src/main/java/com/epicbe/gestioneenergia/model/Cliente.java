package com.epicbe.gestioneenergia.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="clienti")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String ragioneSociale;
	
	@Enumerated(EnumType.STRING)
	private ECliente tipoCliente;
	
	@Column(nullable = false, unique = true, length = 11)
	private Long partitaIva;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	private LocalDate inserimento;
	
	private LocalDate ultimoContatto;
	
	@Column(nullable = false, unique = true)
	private String pec;
	
	@Column(nullable = false)
	private String telefono;
	
	@Column(nullable = false)
	private String emailContatto;	
	private String nomeContatto;
	private String cognomeContatto;
	private String telefonoContatto;
	
	@OneToMany
	private List<Indirizzo> indirizzi;
	
	@OneToMany
	private List<Fattura> fatture;
	
}
