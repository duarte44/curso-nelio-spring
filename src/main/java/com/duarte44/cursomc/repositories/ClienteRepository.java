package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
