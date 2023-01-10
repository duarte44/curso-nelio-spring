package com.duarte44.cursomc.services;

import com.duarte44.cursomc.DTO.CategoriaDTO;
import com.duarte44.cursomc.domain.Categoria;
import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.repositories.CategoriaRepository;
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
public class CategoriaService {

    @Autowired //instancia automaticamente
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public  Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj){
        Categoria newObj =  find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

   public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");

        }
   }
   public List<Categoria> findAll(){
       return repo.findAll();
   }

   public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
       PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy );
       return repo.findAll(pageRequest);
   }

   public Categoria fromDTO(CategoriaDTO objDTO){ //Instancia uma categoria apartir de uma categoriaDTO para fazer as validações
        return new Categoria(objDTO.getId(), objDTO.getNome());
   }

    private void updateData(Categoria newObj, Categoria obj){
        newObj.setNome(obj.getNome());

    }
}

