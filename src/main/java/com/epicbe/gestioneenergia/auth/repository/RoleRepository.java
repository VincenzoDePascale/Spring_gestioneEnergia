package com.epicbe.gestioneenergia.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epicbe.gestioneenergia.auth.entity.ERole;
import com.epicbe.gestioneenergia.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
