package br.minhaigreja.dto;

import java.io.Serializable;

import br.minhaigreja.models.Congregation;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CongregationDTO implements Serializable {
	
	private static final long serialVersionUID = 5659324522785416382L;
	
	private String id;
	
    private String nome;
    
    private String endereco;
    
    private String contato;
    
    public Congregation toEntity() {
        Congregation entity = new Congregation();
        entity.setNome(nome);
        entity.setEndereco(endereco);
        entity.setContato(contato);
        return entity;
    }
}
