package br.minhaigreja.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseDTO<T> implements Serializable {

	private static final long serialVersionUID = 4753125837425084289L;

	private Boolean success;
	
	private Integer numberOfElements;
	
	private T response;
}
