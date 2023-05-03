package com.epicbe.gestioneenergia.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicbe.gestioneenergia.model.Comune;

@Configuration
public class ComuneConfiguration {

	@Bean("CostumComune")
	@Scope("prototype")
	public Comune costumComune() {
		return new Comune();
	}

}
