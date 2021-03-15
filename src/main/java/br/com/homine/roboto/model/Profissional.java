package br.com.homine.roboto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "acp_profissionais")
@Entity
public class Profissional {
	@Id
	@Column(name = "profissionalId")
	private Long profissionalId;

	@Column(name = "Ativo")
	private Boolean ativo;

}
