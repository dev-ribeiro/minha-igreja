package br.minhaigreja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.minhaigreja.dto.AdminDTO;
import br.minhaigreja.dto.ResponseDTO;
import br.minhaigreja.models.Admin;
import br.minhaigreja.services.AdminService;

@RestController
@RequestMapping(path = "api/auth")
public class AuthenticationRestController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<Admin>> register(@RequestBody AdminDTO adminDTO) {
		var result = adminService.register(adminDTO);
		
		var response = new ResponseDTO<Admin>();
		
		response.setSuccess(true);
		
		response.setResponse(result);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path = "authenticate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<String>> authenticate(@RequestBody AdminDTO adminDTO) throws Exception {
		var result = adminService.autenticate(adminDTO);
		
		var response = new ResponseDTO<String>();
		
		response.setSuccess(true);
		
		response.setResponse(result);
		
		return new ResponseEntity<>(response, HttpStatus.OK);		
	}
}
