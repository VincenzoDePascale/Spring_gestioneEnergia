package com.epicbe.gestioneenergia.auth.service;

import com.epicbe.gestioneenergia.auth.payload.LoginDto;
import com.epicbe.gestioneenergia.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
