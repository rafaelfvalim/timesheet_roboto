package br.com.homine.roboto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "acp_profissionais")
public class Profissional {
	@Id
	@Column(name = "profissionalId")
	private Long profissionalId;

	@Column(name = "Ativo")
	private Boolean ativo;
	
}
