package br.com.homine.roboto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.homine.roboto.model.TimeSheet;

public interface TimeSheetRepository  extends  JpaRepository<TimeSheet, Long> {
	
   public List<TimeSheet> findByUsuarioId(Long usuarioId);
   public TimeSheet findTopByUsuarioIdOrderByDataDesc(Long usuarioId);
   
}
