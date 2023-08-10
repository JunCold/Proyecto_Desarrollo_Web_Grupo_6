package com.ProyectoGrupo6.serviceImpl;

import com.ProyectoGrupo6.domain.Rol;
import com.ProyectoGrupo6.dao.RolDao;
import com.ProyectoGrupo6.domain.Usuario;
import com.ProyectoGrupo6.dao.UsuarioDao;
import com.ProyectoGrupo6.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getCedulaUsuario()).orElse(null);
    }


    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
         return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }

    @Override
    public boolean existeUsuarioPorUsernameOCorreo(String username, String correo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Usuario usuario, boolean crearRolUser) {
       usuario=usuarioDao.save(usuario);
        if (crearRolUser) {  //Si se está creando el usuario, se crea el rol por defecto "USER"
            Rol rol = new Rol();
            rol.setNombre("ROLE_EMPLEADO");
            rol.setCedulaUsuario(usuario.getCedulaUsuario());
            rolDao.save(rol);
        }
    }
     @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
