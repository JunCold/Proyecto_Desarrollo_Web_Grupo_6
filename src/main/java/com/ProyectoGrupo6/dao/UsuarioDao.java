
package com.ProyectoGrupo6.dao;

import com.ProyectoGrupo6.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioDao extends JpaRepository<Usuario, String> {
    
}
