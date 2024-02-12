package br.minhaigreja.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
import br.minhaigreja.utils.exceptions.MessagesException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService implements UserDetailsService {

	private final AdminRepository adminRepository;

	private final RoleRepository roleRepository;

	private final AdminRoleRepository adminRoleRepository;

	private final PasswordEncoder passwordEncoder;

	private final JwtService jwtService;

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

	public String autenticate(AdminDTO adminDTO) throws Exception {
		var user = loadUserByUsername(adminDTO.getEmail());

		var passwordMatches = passwordEncoder.matches(adminDTO.getPassword(), user.getPassword());

		if (passwordMatches == true) {
			
			var authenticatedUser = new UsernamePasswordAuthenticationToken(adminDTO.getEmail(),
					adminDTO.getPassword());

			return jwtService.generateToken(authenticatedUser);
		} else {
			throw new Exception(MessagesException.unableToAuthenticateUser);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		var user = adminRepository.findByEmail(username);

		if (user.isPresent()) {
			return user.get();
		} else {
			throw new UsernameNotFoundException(MessagesException.unableToAuthenticateUser);
		}
	}

	private List<Role> registerCustomerRoles(Admin admin) {
		List<Role> roles = new ArrayList<Role>();

		var customerRole = roleRepository.findById(2);

		roles.add(customerRole.get());

		for (Role role : roles) {
			var adminRole = new AdminRole();

			adminRole.setAdmin(admin.getId());

			adminRole.setRole(role.getId());

			adminRoleRepository.save(adminRole);
		}

		return roles;
	}
}
