package br.com.homine.roboto.helper;

import br.com.homine.roboto.model.Usuario;
import br.com.homine.roboto.services.EmailService;
import br.com.homine.roboto.services.MailContentBuilder;

public class MensagemEmailHelper {

	public static String escolheLayout(Long diasDeAtraso) {

		if (diasDeAtraso > 10) {
			return "emails/mailTemplateRaivoso";
		}

		if (diasDeAtraso > 5) {
			return "emails/mailTemplateChateado";
		}

		return "emails/mailTemplateBom";
	}

	public static void montaEmail(MailContentBuilder mailContentBuilder, EmailService emailService, Usuario usuario,
			Long dias) {
		String message = mailContentBuilder.generateMailContent(usuario, dias);
		emailService.sendComplexMessage(usuario.getEmail(), "Apontamento de horas TimeSheet", message);
	}
}
