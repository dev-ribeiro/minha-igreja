package br.minhaigreja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.minhaigreja.dto.AdminDTO;
import br.minhaigreja.models.Admin;
import br.minhaigreja.repositories.AdminRepository;

@Service
public class AdminService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin save(AdminDTO adminDTO) {
		return adminRepository.save(adminDTO.toEntity());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(username);
	}
}
