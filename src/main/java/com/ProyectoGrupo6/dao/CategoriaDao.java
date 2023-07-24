package com.ProyectoGrupo6.dao;

import com.ProyectoGrupo6.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}

