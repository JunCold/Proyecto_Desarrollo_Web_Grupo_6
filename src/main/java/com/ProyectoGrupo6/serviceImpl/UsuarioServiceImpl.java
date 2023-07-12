package com.ProyectoGrupo6.serviceImpl;

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

    @Override
    public List<Usuario> getUsuario(String cedula) {
       List<Usuario> usuarios= usuarioDao.findAll();
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getCedula()!=cedula){
                usuarios.remove(i);
            }
            
        }
        return usuarios;
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
       return usuarioDao.findById(usuario.getCedula()).orElse (null);
    }

    @Override
    public void save(Usuario usuario) {
       usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
}
