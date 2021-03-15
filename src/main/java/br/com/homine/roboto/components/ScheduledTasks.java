package br.com.homine.roboto.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.homine.roboto.helper.ApontamentoHelper;
import br.com.homine.roboto.helper.MensagemEmailHelper;
import br.com.homine.roboto.model.Usuario;
import br.com.homine.roboto.repository.TimeSheetRepository;
import br.com.homine.roboto.repository.UsuarioRepository;
import br.com.homine.roboto.services.EmailService;
import br.com.homine.roboto.services.MailContentBuilder;

@Component
public class ScheduledTasks {
	@Autowired
	public SimpleMailMessage template;
	@Autowired
	public EmailService emailService;

	@Autowired
	MailContentBuilder mailContentBuilder;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	TimeSheetRepository timeSheetRepository;
	
	@Scheduled(fixedRate = 500)
	public void executeEmailTask() {

//		for (Usuario usuario : usuarioRepository.findAll()) {
//			System.out.println(usuario.getNome());
//			if(usuario.getUsuarioId() != new Long(1171)) {
//				continue;
//			}
//			Date dataUltimoApontamento = ApontamentoHelper.getUltimoApontamento(timeSheetRepository, usuario.getUsuarioId());
//			int dias = ApontamentoHelper.calculaDiasSemApontar(dataUltimoApontamento);
//			if(ApontamentoHelper.isApontamentoEmAtraso(dias)) {
//				System.out.println("Usuário: " + usuario.getNome() + "Ultimo apontamento: " + dataUltimoApontamento);
//				MensagemEmailHelper.montaEmail(mailContentBuilder, emailService, usuario);
//			}	
//		}

	}
}