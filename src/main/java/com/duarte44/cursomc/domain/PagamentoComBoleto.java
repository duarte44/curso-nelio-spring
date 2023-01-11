package com.duarte44.cursomc.domain;

import com.duarte44.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@JsonTypeName("pagamentoComBoleto") //palavra q vai mapear a classe
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersion = 1L;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataVencimento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
