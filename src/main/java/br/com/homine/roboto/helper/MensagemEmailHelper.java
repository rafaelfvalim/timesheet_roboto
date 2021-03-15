package br.com.homine.roboto.helper;

import br.com.homine.roboto.model.Usuario;
import br.com.homine.roboto.services.EmailService;
import br.com.homine.roboto.services.MailContentBuilder;

public class MensagemEmailHelper {

	public static String escolheLayout(int diasDeAtraso ) {
		return "emails/mailTemplate";
	}
	
	public static void montaEmail(MailContentBuilder mailContentBuilder, EmailService emailService, Usuario usuario) {
		String message = mailContentBuilder.generateMailContent(usuario);
		emailService.sendComplexMessage(usuario.getEmail(),"Apontamento de horas TimeSheet", message);
	}
}
