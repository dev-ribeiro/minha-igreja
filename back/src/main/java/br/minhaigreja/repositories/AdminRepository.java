package br.minhaigreja.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.minhaigreja.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
	
	Optional<Admin> findByEmail(String email);
}
