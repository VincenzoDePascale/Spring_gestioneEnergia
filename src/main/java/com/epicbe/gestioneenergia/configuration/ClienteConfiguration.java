package com.epicbe.gestioneenergia.configuration;


import java.time.LocalDate;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.ECliente;
import com.github.javafaker.Faker;

@Configuration
public class ClienteConfiguration {
	@Bean("ClienteRandom")
	@Scope("prototype")
	public Cliente clienteRandom() {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder()
				.ragioneSociale(fake.company().bs())
				.tipoCliente(ECliente.eClienteRandom())
				.partitaIva((long) fake.number().numberBetween(11, 11))
				.email(fake.internet().emailAddress())
				.inserimento(LocalDate.of(fake.number().numberBetween(2021, 2022),fake.number().numberBetween(1, 12), fake.number().numberBetween(1, 28)))
				.ultimoContatto(LocalDate.of(fake.number().numberBetween(2021, 2022),fake.number().numberBetween(1, 12), fake.number().numberBetween(1, 28)))
				.pec(fake.internet().emailAddress())
				.telefono(fake.phoneNumber().phoneNumber())
				.emailContatto(fake.internet().emailAddress().toUpperCase())
				.nomeContatto(fake.name().firstName())
				.cognomeContatto(fake.name().lastName())
				.telefonoContatto(fake.phoneNumber().phoneNumber())
				.build();
	}
	
	
}
