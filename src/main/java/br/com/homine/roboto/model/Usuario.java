package br.com.homine.roboto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "acp_Usuario")
@Entity
public class Usuario {
	@Id
	@Column( name = "UsuarioID" )
	private Long usuarioId;
	
	@Column(name = "Nome" )
	private String nome;
	
	@Column(name = "Email" )
	private String email;
	
}
