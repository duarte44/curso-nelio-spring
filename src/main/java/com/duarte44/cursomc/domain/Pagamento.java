package com.duarte44.cursomc.domain;

import com.duarte44.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED) //super classe da herança
public abstract class Pagamento implements Serializable {  //serve para q os objetos possam ser gravados em arquivos
    private static final long serialVersion = 1L;

    @Id
    private Integer id;
    private Integer estado;

    @JsonIgnore //serialização ciclica
    @OneToOne
    @JoinColumn(name="pedido_id")
    @MapsId //pega o mesmo ID de pedido
    private Pedido pedido;

    public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
        this.id = id;
        this.estado = (estado==null) ? null : estado.getCod();
        this.pedido = pedido;
    }

    public EstadoPagamento getEstado() {
        return EstadoPagamento.toEnum(estado);
    }

    public void setEstado(EstadoPagamento estado) {
        this.estado = estado.getCod();
    }
}
