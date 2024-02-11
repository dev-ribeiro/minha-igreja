package br.minhaigreja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.minhaigreja.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
