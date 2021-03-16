package br.com.homine.roboto.components;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.homine.roboto.helper.ApontamentoHelper;
import br.com.homine.roboto.helper.MensagemEmailHelper;
import br.com.homine.roboto.model.Profissional;
import br.com.homine.roboto.model.Usuario;
import br.com.homine.roboto.repository.ProfissionalRepository;
import br.com.homine.roboto.repository.TimeSheetRepository;
import br.com.homine.roboto.repository.UsuarioRepository;
import br.com.homine.roboto.services.EmailService;
import br.com.homine.roboto.services.MailContentBuilder;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	EmailService emailService;

	@Autowired
	MailContentBuilder mailContentBuilder;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TimeSheetRepository timeSheetRepository;

	@Autowired
	ProfissionalRepository profissionalRepository;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {

		for (Usuario usuario : usuarioRepository.findAll()) {

			if (!profissionalRepository.findById(usuario.getProfissionalId()).get().getAtivo())
				continue;

			if ("".equals(usuario.getEmail()))
				continue;

			if ((long) usuario.getUsuarioId() != (long) 1171)
				continue;

			Date dataUltimoApontamento = ApontamentoHelper.getUltimoApontamento(timeSheetRepository,
					usuario.getUsuarioId());

			if (dataUltimoApontamento == null)
				continue;

			Long dias = ApontamentoHelper.calculaDiasSemApontar(dataUltimoApontamento);

			if (ApontamentoHelper.isApontamentoEmAtraso(dias)) {
				MensagemEmailHelper.montaEmail(mailContentBuilder, emailService, usuario, dias);
			}
		}
	}
}