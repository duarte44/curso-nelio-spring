package com.duarte44.cursomc.resources;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Pedido;
import com.duarte44.cursomc.services.ClienteService;
import com.duarte44.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscar(@PathVariable Integer id){

        Pedido obj = service.find(id);
       return ResponseEntity.ok().body(obj);



    }
}
