package br.minhaigreja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.minhaigreja.models.Congregation;

public interface CongregationRepository extends JpaRepository<Congregation, String> {

}
