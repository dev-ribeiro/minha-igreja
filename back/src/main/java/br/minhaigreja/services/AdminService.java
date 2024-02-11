package br.minhaigreja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.minhaigreja.dto.AdminDTO;
import br.minhaigreja.models.Admin;
import br.minhaigreja.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin save(AdminDTO adminDTO) {
		return adminRepository.save(adminDTO.toEntity());
	}
	
	public Admin findByEmail(AdminDTO adminDTO) {
		return adminRepository.findByEmail(adminDTO.getEmail());
	}
}
