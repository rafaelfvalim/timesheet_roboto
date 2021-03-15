package br.com.homine.roboto.services;

import br.com.homine.roboto.model.Usuario;

public interface MailContentBuilder {
	String generateMailContent(Usuario usuario, Long dias);
}
