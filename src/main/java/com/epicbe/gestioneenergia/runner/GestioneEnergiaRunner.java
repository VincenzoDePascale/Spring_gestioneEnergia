package com.epicbe.gestioneenergia.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.epicbe.gestioneenergia.service.ClienteService;
import com.epicbe.gestioneenergia.service.IndirizzoService;

@Component
public class GestioneEnergiaRunner implements ApplicationRunner {

	@Autowired IndirizzoService indirizzoService;
	@Autowired ClienteService clientService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Wait for it ...");
		
		
		//Creazione clienti
		for (int i = 0; i<25; i++) {
			//clientService.createClienteRandom();
			//indirizzoService.createFakeIndirizzo();			
		}
	}
	
	

}
