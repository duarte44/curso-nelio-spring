package com.duarte44.cursomc.services;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.ItemPedido;
import com.duarte44.cursomc.domain.PagamentoComBoleto;
import com.duarte44.cursomc.domain.Pedido;
import com.duarte44.cursomc.domain.enums.EstadoPagamento;
import com.duarte44.cursomc.repositories.ItemPedidoRepository;
import com.duarte44.cursomc.repositories.PagamentoRepository;
import com.duarte44.cursomc.repositories.PedidoRepository;
import com.duarte44.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
public interface EmailService {

   void sendOrderConfirmationEmail(Pedido ojb);


   void sendEmail(SimpleMailMessage msg);
}

