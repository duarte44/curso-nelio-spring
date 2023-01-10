package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Cidade;
import com.duarte44.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
