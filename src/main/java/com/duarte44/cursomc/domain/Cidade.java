package com.duarte44.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Entity
public class Cidade implements Serializable {  //serve para q os objetos possam ser gravados em arquivos
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="estado_id") //associação com Estado
    private Estado estado;  //Na RELAÇÃO muitos para UM o objeto se passa no construtor

    public static class PagamentoComCartao {

        private Integer numeroParcelas;
    }
}
