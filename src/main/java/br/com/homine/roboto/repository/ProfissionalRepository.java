package br.com.homine.roboto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homine.roboto.model.Profissional;

public interface ProfissionalRepository  extends  JpaRepository<Profissional, Long> {
	
}
