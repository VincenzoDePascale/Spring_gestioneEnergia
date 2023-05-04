package com.epicbe.gestioneenergia.configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.service.ClienteService;
import com.epicbe.gestioneenergia.model.Fattura;
import com.epicbe.gestioneenergia.model.Stato;
import com.github.javafaker.Faker;

@Configuration
public class FatturaConfiguration {
	
	@Autowired ClienteService clientService;
	
	
	@Bean("CreaFattura")
	@Scope("prototype")
	public Fattura creaFattura(Integer num, Integer anno, LocalDate data, BigDecimal importo, Cliente cliente, Stato stato ) {
		return Fattura.builder()
				.numero(num)
				.anno(anno)
				.data(data)
				.importo(importo)
				.cliente(cliente)
				.stato(stato)
				.build();
	}
	
	
	@Bean("CreaFatturaFake")
	@Scope("prototype")
	public Fattura creaFatturaFake() {
	Faker fake = new Faker(new Locale("it-IT"));
	long minDay = LocalDate.of(2020, 1, 1).toEpochDay();
    long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
	return Fattura.builder()
			.numero(fake.number().numberBetween(1, 99999999))
			.anno(fake.number().numberBetween(2020, 2024))
			.data(randomDate)
			.importo(BigDecimal.valueOf(fake.number().randomDouble(2, 0, 1000)))
			.cliente(clientService.getClienteRandom())
			.stato(Stato.statoRandom())
			.build();
	
	}

}
