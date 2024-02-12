package br.minhaigreja.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "congregation", schema = "gestao")
@Data
public class Congregation {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(name = "nome", nullable = false, length = 255)
	private String name;

	@Column(name = "endereco", nullable = true, length = 255)
	private String endereco;

	@Column(name = "contato", nullable = true, length = 255)
	private String contato;
	
	@JoinColumn(name = "admin_id", nullable = false)
	private Admin admin;
}
