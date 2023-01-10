package com.duarte44.cursomc.services;

import com.duarte44.cursomc.DTO.CategoriaDTO;
import com.duarte44.cursomc.DTO.ClienteDTO;
import com.duarte44.cursomc.DTO.ClienteNewDto;
import com.duarte44.cursomc.domain.Categoria;
import com.duarte44.cursomc.domain.Cidade;
import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Endereco;
import com.duarte44.cursomc.domain.enums.TipoCliente;
import com.duarte44.cursomc.repositories.CategoriaRepository;
import com.duarte44.cursomc.repositories.CidadeRepository;
import com.duarte44.cursomc.repositories.ClienteRepository;
import com.duarte44.cursomc.repositories.EnderecoRepository;
import com.duarte44.cursomc.services.exceptions.DataIntegrityException;
import com.duarte44.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired //instancia automaticamente
    private ClienteRepository repo;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public  Cliente insert(Cliente obj){
        obj.setId(null);
        obj =  repo.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }


    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente update(Cliente obj){
       Cliente newObj =  find(obj.getId());
       updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException("Não é possivel excluir um cliente que contem pedidos");

        }
    }
    public List<Cliente> findAll(){
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDTO){ //Instancia uma categoria apartir de uma categoriaDTO para fazer as validações
       return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDto objDto){
        Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
        Cidade cid = cidadeRepository.findById(objDto.getCidadeId()).get();
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if(objDto.getTelefone1() != null){
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if(objDto.getTelefone2() != null){
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}

