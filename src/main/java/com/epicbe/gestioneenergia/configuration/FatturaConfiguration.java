package com.epicbe.gestioneenergia.configuration;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicbe.gestioneenergia.model.Cliente;
import com.epicbe.gestioneenergia.model.Fattura;

@Configuration
public class FatturaConfiguration {
	
	
	@Bean("CreaFattura")
	@Scope("prototype")
	public Fattura creaFattura(Integer num, Integer anno, Date data, BigDecimal importo, Cliente cliente ) {
		return Fattura.builder()
				.numero(num)
				.anno(anno)
				.data(data)
				.importo(importo)
				.cliente(cliente)
				.build();
	}

}
