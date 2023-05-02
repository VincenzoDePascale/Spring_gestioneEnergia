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
	@Bean("PACliente")
	@Scope("prototype")
	public Cliente PacCliente(LocalDate data, LocalDate dataUltimo) {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder()
				.ragioneSociale(fake.company().bs())
				.tipoCliente(ECliente.PA)
				.partitaIva((long) fake.number().numberBetween(11, 11))
				.email(fake.internet().emailAddress())
				.inserimento(data)
				.ultimoContatto(dataUltimo)
				.pec(fake.internet().emailAddress())
				.telefono(fake.phoneNumber().phoneNumber())
				.emailContatto(fake.internet().emailAddress().toUpperCase())
				.nomeContatto(fake.name().firstName())
				.cognomeContatto(fake.name().lastName())
				.telefonoContatto(fake.phoneNumber().phoneNumber())
				.build();
	}
	
	
	@Bean("SASCliente")
	@Scope("prototype")
	public Cliente SASCliente(LocalDate data, LocalDate dataUltimo) {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder()
				.ragioneSociale(fake.company().bs())
				.tipoCliente(ECliente.SAS)
				.partitaIva((long) fake.number().numberBetween(11, 11))
				.email(fake.internet().emailAddress())
				.inserimento(data)
				.ultimoContatto(dataUltimo)
				.pec(fake.internet().emailAddress())
				.telefono(fake.phoneNumber().phoneNumber())
				.emailContatto(fake.internet().emailAddress().toUpperCase())
				.nomeContatto(fake.name().firstName())
				.cognomeContatto(fake.name().lastName())
				.telefonoContatto(fake.phoneNumber().phoneNumber())
				.build();
	}
	
	@Bean("SPACliente")
	@Scope("prototype")
	public Cliente SPASCliente(LocalDate data, LocalDate dataUltimo) {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder()
				.ragioneSociale(fake.company().bs())
				.tipoCliente(ECliente.SPA)
				.partitaIva((long) fake.number().numberBetween(11, 11))
				.email(fake.internet().emailAddress())
				.inserimento(data)
				.ultimoContatto(dataUltimo)
				.pec(fake.internet().emailAddress())
				.telefono(fake.phoneNumber().phoneNumber())
				.emailContatto(fake.internet().emailAddress().toUpperCase())
				.nomeContatto(fake.name().firstName())
				.cognomeContatto(fake.name().lastName())
				.telefonoContatto(fake.phoneNumber().phoneNumber())
				.build();
	}
	
	@Bean("SRLCliente")
	@Scope("prototype")
	public Cliente SRLCliente(LocalDate data, LocalDate dataUltimo) {
		Faker fake = new Faker(new Locale("it-IT"));
		return Cliente.builder()
				.ragioneSociale(fake.company().bs())
				.tipoCliente(ECliente.SRL)
				.partitaIva((long) fake.number().numberBetween(11, 11))
				.email(fake.internet().emailAddress())
				.inserimento(data)
				.ultimoContatto(dataUltimo)
				.pec(fake.internet().emailAddress())
				.telefono(fake.phoneNumber().phoneNumber())
				.emailContatto(fake.internet().emailAddress().toUpperCase())
				.nomeContatto(fake.name().firstName())
				.cognomeContatto(fake.name().lastName())
				.telefonoContatto(fake.phoneNumber().phoneNumber())
				.build();
	}
}
