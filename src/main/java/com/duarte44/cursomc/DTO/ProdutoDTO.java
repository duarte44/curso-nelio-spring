package com.duarte44.cursomc.DTO;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Produto;
import com.duarte44.cursomc.services.validation.ClienteUpdate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


public class ProdutoDTO implements Serializable {  //serve para q os objetos possam ser gravados em arquivos
    private static final long serialVersion = 1L;

    private Integer id;
    private String nome;
    private Double preco;

    public ProdutoDTO(){

    }

    public ProdutoDTO(Produto obj){
        this.id= obj.getId();
        this.nome = obj.getNome();
        this.preco = obj.getPreco();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
