package com.duarte44.cursomc.resources;

import com.duarte44.cursomc.domain.Categoria;
import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Pedido;
import com.duarte44.cursomc.services.ClienteService;
import com.duarte44.cursomc.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscar(@PathVariable Integer id) {

        Pedido obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

        @RequestMapping(method = RequestMethod.POST)
        public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //pega o id passado e coloca no objeto criado
            return ResponseEntity.created(uri).build();

    }
}
