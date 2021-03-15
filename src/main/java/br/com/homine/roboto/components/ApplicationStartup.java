package br.com.homine.roboto.components;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import br.com.homine.roboto.helper.ApontamentoHelper;
import br.com.homine.roboto.helper.MensagemEmailHelper;
import br.com.homine.roboto.model.Usuario;
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
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {

		for (Usuario usuario : usuarioRepository.findAll()) {
			System.out.println(usuario.getNome() + "" + usuario.getUsuarioId() );
			if((long) usuario.getUsuarioId() != (long) 1171) {
				continue;
			}
			Date dataUltimoApontamento = ApontamentoHelper.getUltimoApontamento(timeSheetRepository, usuario.getUsuarioId());
			Long dias = ApontamentoHelper.calculaDiasSemApontar(dataUltimoApontamento);
			if(ApontamentoHelper.isApontamentoEmAtraso(dias)) {
				System.out.println("Usuário: " + usuario.getNome() + "Ultimo apontamento: " + dataUltimoApontamento);
				MensagemEmailHelper.montaEmail(mailContentBuilder, emailService, usuario, dias);
			}	
		}
	}
}