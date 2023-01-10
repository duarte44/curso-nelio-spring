package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Pagamento;
import com.duarte44.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
