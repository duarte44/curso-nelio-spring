package com.duarte44.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Entity
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;  //serve para q os objetos possam ser gravados em arquivos


    @JsonIgnore //serialização ciclica de chave composta
    @EmbeddedId //chave auxiliar
    private ItemPedidoPK id = new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setPedido(pedido);
        id.setProduto(produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getSubTotal(){
        return (preco - desconto) * quantidade;
    }

    @JsonIgnore //refecencia ciclica
    public Pedido getPedido(){
        return id.getPedido();
    }


    public Produto getProduto(){
        return id.getProduto();
    }

    public Double getDesconto() {
        return desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}


