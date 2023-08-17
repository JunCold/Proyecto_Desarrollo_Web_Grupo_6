
package com.ProyectoGrupo6.service;

import com.ProyectoGrupo6.domain.Producto;
import java.util.List;
public interface ProductoService {
    public List <Producto> getProductos(boolean activos);
    
    public Producto getProducto(Producto producto);
    public void save(Producto producto);
    public void delete (Producto producto);
    
    //Metodo para buscar un producto por su codigo
    public Producto findByCodigo(Long codigoProducto);
    
    //Metodo para aumentar la cantidad de productos en existencia
    public Producto aumentarProducto(Long codigoProducto, Long cantidad);
    
    //Metodo para disminuir la cantidad de productos en existencia
    public Producto disminuirProducto(Long codigoProducto, Long cantidad);
}
