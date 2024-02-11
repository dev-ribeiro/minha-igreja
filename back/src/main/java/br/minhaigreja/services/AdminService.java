package br.minhaigreja.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.minhaigreja.dto.AdminDTO;
import br.minhaigreja.models.Admin;
import br.minhaigreja.models.AdminRole;
import br.minhaigreja.models.Role;
import br.minhaigreja.repositories.AdminRepository;
import br.minhaigreja.repositories.AdminRoleRepository;
import br.minhaigreja.repositories.RoleRepository;
import jakarta.transaction.Transactional;

@Service
public class AdminService implements UserDetailsService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AdminRoleRepository adminRoleRepository;	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public Admin register(AdminDTO adminDTO) {
		var user = new Admin();
		
		user.setName(adminDTO.getName());
		
		user.setEmail(adminDTO.getEmail());
		
		user.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
		
		var admin = adminRepository.save(user);
		
		var roles = registerCustomerRoles(admin);
		
		admin.setRoles(roles);
		
		return admin;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(username);
	}
	
	private List<Role> registerCustomerRoles(Admin admin) {
		List<Role> roles = new ArrayList<Role>();
		
		var customerRole = roleRepository.findById(2);

		roles.add(customerRole.get());
		
		for(Role role : roles) {
			var adminRole = new AdminRole();
			
			adminRole.setAdmin(admin.getId());
			
			adminRole.setRole(role.getId());
			
			adminRoleRepository.save(adminRole);	
		}
		
		return roles;
	}
}
