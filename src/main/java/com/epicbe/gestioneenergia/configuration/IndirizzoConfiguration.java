package com.epicbe.gestioneenergia.configuration;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.ECliente;
import com.epicbe.gestioneenergia.model.Indirizzo;
import com.epicbe.gestioneenergia.repository.ClienteRepository;
import com.epicbe.gestioneenergia.repository.ComuneRepository;
import com.github.javafaker.Faker;


@Configuration
public class IndirizzoConfiguration {

	@Autowired ComuneRepository repoComune;
	@Autowired ClienteRepository repoCliente;

	
	@Bean("CustomIndirizzoBean")
	@Scope("prototype")
	public Indirizzo newCustomIndirizzo() {
		return new Indirizzo();
	}
	
	@Bean ("FakeIndirizzo")
	@Scope("prototype")
	public Indirizzo indirizzoRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Indirizzo.builder()
				.via(fake.address().streetAddress())
				.civico(fake.address().streetAddressNumber())	
				.comune(repoComune.findByComuneRandom())
				.cap(fake.number().numberBetween(00000, 99999))
				.cliente(repoCliente.findByClienteRandom())
				.build();
		
	}
}
