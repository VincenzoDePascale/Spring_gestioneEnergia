package com.epicbe.gestioneenergia.runner;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.epicbe.gestioneenergia.auth.entity.ERole;
import com.epicbe.gestioneenergia.auth.entity.Role;
import com.epicbe.gestioneenergia.auth.repository.RoleRepository;
import com.epicbe.gestioneenergia.auth.repository.UserRepository;
import com.epicbe.gestioneenergia.auth.service.AuthService;
import com.epicbe.gestioneenergia.service.ClienteService;
import com.epicbe.gestioneenergia.service.FatturaService;
import com.epicbe.gestioneenergia.service.IndirizzoService;

import lombok.extern.slf4j.Slf4j;

@Component
public class GestioneEnergiaRunner implements ApplicationRunner {

	@Autowired IndirizzoService indirizzoService;
	@Autowired ClienteService clientService;
	@Autowired FatturaService fatturaService;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthService authService;

	private static Set<Role> adminRole;
	private static Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Wait for it ...");
		
		//SETTA RUOLI ADMIN/USER IN DB
		//setRoleDefault();
		
		//REGISTRARSI QUI TRAMITE ENDPOINT
		
		//IMPORTARE I COMUNI DA CSV QUI DA POSTMAN
		
		//CREA ENTITA DI DEFAULT NEL DB	
		//starterDB();

	}
	
	private void starterDB() {

		for (int i = 0; i<10; i++) {
			clientService.createClienteRandom();
		}
		
		/*for (int i = 0; i<30; i++) {
			indirizzoService.createFakeIndirizzo();			
		}*/
	
		for (int i = 0; i<100; i++) {
			fatturaService.creaFatturaFake();
		}
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);

		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(user);

		userRole = new HashSet<Role>();
		userRole.add(user);
	}
}
