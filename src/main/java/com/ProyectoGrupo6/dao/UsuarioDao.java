
package com.ProyectoGrupo6.dao;

import com.ProyectoGrupo6.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioDao extends JpaRepository<Usuario, String> {
    Usuario findByUsername(String username);
    
    Usuario findByUsernameAndPassword(String username, String password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}
