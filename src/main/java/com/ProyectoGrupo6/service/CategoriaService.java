
package com.ProyectoGrupo6.service;

import com.ProyectoGrupo6.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getcategoria(Categoria categoria);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);

    public Categoria getCategoria(Categoria categoria);
}
