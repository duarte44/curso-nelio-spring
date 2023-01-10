package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Endereco;
import com.duarte44.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
