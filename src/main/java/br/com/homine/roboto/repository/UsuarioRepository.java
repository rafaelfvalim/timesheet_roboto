package br.com.homine.roboto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homine.roboto.model.Usuario;

public interface UsuarioRepository  extends  JpaRepository<Usuario, Long> {
	
}
