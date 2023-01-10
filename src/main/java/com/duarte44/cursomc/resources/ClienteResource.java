package com.duarte44.cursomc.resources;

import com.duarte44.cursomc.DTO.CategoriaDTO;
import com.duarte44.cursomc.DTO.ClienteDTO;
import com.duarte44.cursomc.DTO.ClienteNewDto;
import com.duarte44.cursomc.domain.Categoria;
import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.services.CategoriaService;
import com.duarte44.cursomc.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {

        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

        @RequestMapping(value="/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id){
            Cliente obj = service.fromDTO(objDTO);
            obj.setId(id);
            obj = service.update(obj);
            return ResponseEntity.noContent().build();
        }

        @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
            service.delete(id);
            return ResponseEntity.noContent().build();

        }

        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<List<ClienteDTO>> findAll(){
            List<Cliente> list = service.findAll();
            List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listDTO);
        }

        @RequestMapping(value="/page", method = RequestMethod.GET)
        public ResponseEntity<Page<ClienteDTO>> findPage(
                @RequestParam(value ="page", defaultValue = "0") Integer page,
                @RequestParam(value ="linesPerPage", defaultValue = "24") Integer linesPerPage,
                @RequestParam(value ="orderBy", defaultValue = "nome") String orderBy,
                @RequestParam(value ="direction", defaultValue = "ASC")String direction){
            Page<Cliente> list = service.findPage(page, linesPerPage, orderBy, direction);
            Page<ClienteDTO> listDTO = list.map(obj -> new ClienteDTO(obj));
            return ResponseEntity.ok().body(listDTO);
        }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDto objDTO){
        Cliente obj = service.fromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); //pega o id passado e coloca no objeto criado
        return ResponseEntity.created(uri).build();
    }

}
