package com.epicbe.gestioneenergia.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_security_project.auth.entity.ERole;
import com.spring_security_project.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
