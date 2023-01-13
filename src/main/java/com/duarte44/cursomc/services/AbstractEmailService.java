package com.duarte44.cursomc.services;

import com.duarte44.cursomc.domain.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Override
    public void  sendOrderConfirmationEmail(Pedido obj){
        SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getCliente().getEmail()); //pare quem vai ser enviado
        sm.setFrom(sender); //quem vai enviar
        sm.setSubject("Pedido confirmado! Código: " + obj.getId()); //assunto do email
        sm.setSentDate(new Date(System.currentTimeMillis())); //data do email
        sm.setText(obj.toString()); //corpo do email
        return sm;
    }

}
