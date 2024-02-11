package br.minhaigreja.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin_papeis", schema = "gestao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRole implements Serializable {
	
	private static final long serialVersionUID = -8162178213296669891L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn
	@Column(name = "admin_id")
	private String admin;
	
	@JoinColumn
	@Column(name = "roles_id")
	private Integer role;
}
