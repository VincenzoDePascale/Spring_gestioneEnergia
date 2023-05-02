package com.epicbe.gestioneenergia.auth.service;

import com.spring_security_project.auth.payload.LoginDto;
import com.spring_security_project.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
