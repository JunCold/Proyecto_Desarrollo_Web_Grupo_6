
package com.ProyectoGrupo6.service;
import com.ProyectoGrupo6.domain.Usuario;
import java.util.List;

public interface UsuarioService {
    public List<Usuario> getUsuario(String cedula);
    public Usuario getUsuario(Usuario usuario);
    public void save(Usuario usuario);
    public void delete (Usuario usuario);
    
}
