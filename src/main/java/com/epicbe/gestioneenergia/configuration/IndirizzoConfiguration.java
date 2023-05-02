package com.epicbe.gestioneenergia.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicbe.gestioneenergia.model.Indirizzo;


@Configuration
public class IndirizzoConfiguration {

	

	
	@Bean("CustomIndirizzoBean")
	@Scope("prototype")
	public Indirizzo newCustomIndirizzo() {
		return new Indirizzo();
	}
}
