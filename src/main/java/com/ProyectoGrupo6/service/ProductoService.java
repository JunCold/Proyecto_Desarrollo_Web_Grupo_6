
package com.ProyectoGrupo6.service;

import com.ProyectoGrupo6.domain.Producto;
import java.util.List;
public interface ProductoService {
    public List <Producto> getProducto(String codigo);
    
    public Producto getProducto(Producto producto);
    public void save(Producto producto);
    public void delete (Producto producto);
}
