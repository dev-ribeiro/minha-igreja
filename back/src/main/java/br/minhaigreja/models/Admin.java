package br.minhaigreja.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin", schema = "gestao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@Column(name = "nome", nullable = false, unique = false)
	private String name;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "senha", nullable = false, unique = false)
	private String password;
}
