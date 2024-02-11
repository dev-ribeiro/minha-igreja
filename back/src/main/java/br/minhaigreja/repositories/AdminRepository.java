package br.minhaigreja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.minhaigreja.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	Admin findByEmail(String email);
}
