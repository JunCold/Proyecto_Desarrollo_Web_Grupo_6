package com.ProyectoGrupo6.dao;

import com.ProyectoGrupo6.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteDao extends JpaRepository<Cliente, Long>{
    
}
