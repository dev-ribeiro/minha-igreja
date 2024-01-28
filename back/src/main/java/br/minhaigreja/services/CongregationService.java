package br.minhaigreja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.minhaigreja.dto.CongregationDTO;
import br.minhaigreja.dto.ResponseDTO;
import br.minhaigreja.models.Congregation;
import br.minhaigreja.repositories.CongregationRepository;

@Service
public class CongregationService {

	@Autowired
	private CongregationRepository congregationRepository;

	public Congregation registerCongregation(CongregationDTO to) {
		Congregation entity = to.toEntity();
		
		entity = congregationRepository.save(entity);
		
		return entity;
	}
	
	public List<Congregation> findAll() {
		return congregationRepository.findAll();
	}

}
