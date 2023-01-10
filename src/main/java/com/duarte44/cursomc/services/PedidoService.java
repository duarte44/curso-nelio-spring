package com.duarte44.cursomc.services;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Pedido;
import com.duarte44.cursomc.repositories.ClienteRepository;
import com.duarte44.cursomc.repositories.PedidoRepository;
import com.duarte44.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired //instancia automaticamente
    private PedidoRepository repo;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

}

