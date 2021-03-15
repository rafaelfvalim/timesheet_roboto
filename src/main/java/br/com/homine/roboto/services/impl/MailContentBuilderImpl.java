package br.com.homine.roboto.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import br.com.homine.roboto.model.Usuario;
import br.com.homine.roboto.services.MailContentBuilder;

@Service
public class MailContentBuilderImpl implements MailContentBuilder{

    @Autowired
    TemplateEngine templateEngine;

    public String generateMailContent(Usuario usuario) {
        Context context = new Context();
        context.setVariable("nome", usuario.getNome());
        return templateEngine.process("emails/mailTemplate", context);
    }
}