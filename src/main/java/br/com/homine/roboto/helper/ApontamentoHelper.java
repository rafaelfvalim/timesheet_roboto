package br.com.homine.roboto.helper;

import java.time.LocalDate;
import java.util.Date;
import java.time.temporal.ChronoUnit;

import br.com.homine.roboto.repository.TimeSheetRepository;

public class ApontamentoHelper {

	public static Date getUltimoApontamento(TimeSheetRepository timeSheetRepository, Long usuarioId) {
		return timeSheetRepository.findTopByUsuarioIdOrderByDataDesc(usuarioId).getData();
	}

	public static Long calculaDiasSemApontar(Date dataUltimoApontamento) {
		LocalDate ultimoApontamento = DateHelper.dateToLocalDate(dataUltimoApontamento);
		
		LocalDate dataAtual = LocalDate.now();
		if ((ultimoApontamento != null) && (dataAtual != null)) {
			return ChronoUnit.DAYS.between(ultimoApontamento, dataAtual);
		}
		return new Long(0);
	}

	public static boolean isApontamentoEmAtraso(Long dias) {
		if (dias > 1) {
			return true;
		}
		return false;
	}

}
