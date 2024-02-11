package br.minhaigreja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.minhaigreja.models.AdminRole;

public interface AdminRoleRepository extends JpaRepository<AdminRole, Integer> {

}
