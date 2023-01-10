package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
