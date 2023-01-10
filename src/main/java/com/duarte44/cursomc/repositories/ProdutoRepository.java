package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Categoria;
import com.duarte44.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
