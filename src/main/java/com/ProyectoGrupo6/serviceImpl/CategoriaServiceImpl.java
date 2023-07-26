package com.ProyectoGrupo6.serviceImpl;

import com.ProyectoGrupo6.dao.CategoriaDao;
import com.ProyectoGrupo6.domain.Categoria;
import com.ProyectoGrupo6.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> categorias = categoriaDao.findAll();
        if (activos) {
            categorias.removeIf(x -> !x.isActivo());
        }

        return categorias;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria Categoria) {
        return categoriaDao.findById(Categoria.getIdCategoria()).orElse(null);
    }

    @Override
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    public Categoria getcategoria(Categoria categoria) {
        throw new UnsupportedOperationException("No Disponible.");
    }
}
