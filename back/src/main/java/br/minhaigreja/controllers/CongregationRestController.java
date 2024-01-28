package br.minhaigreja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.minhaigreja.dto.CongregationDTO;
import br.minhaigreja.dto.ResponseDTO;
import br.minhaigreja.models.Congregation;
import br.minhaigreja.services.CongregationService;

@RestController
@RequestMapping(path = "api/congregation")
public class CongregationRestController {

	@Autowired
	private CongregationService congregationService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO<Congregation>> registerCongregation(@RequestBody CongregationDTO to) {
		Congregation result = congregationService.registerCongregation(to);

		ResponseDTO<Congregation> response = new ResponseDTO<>();

		response.setSuccess(true);

		response.setResponse(result);

		return new ResponseEntity<ResponseDTO<Congregation>>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseDTO<List<Congregation>>> findAll() {
		List<Congregation> result = congregationService.findAll();

		ResponseDTO<List<Congregation>> response = new ResponseDTO<>();

		response.setResponse(result);

		response.setSuccess(true);
		
		response.setNumberOfElements(result.size());

		return new ResponseEntity<ResponseDTO<List<Congregation>>>(response, HttpStatus.OK);
	}

}
