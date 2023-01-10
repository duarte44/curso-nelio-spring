package com.duarte44.cursomc.repositories;

import com.duarte44.cursomc.domain.Cliente;
import com.duarte44.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);

}
