package com.ProyectoGrupo6.serviceImpl;

import com.ProyectoGrupo6.dao.ProductoDao;
import com.ProyectoGrupo6.domain.Producto;
import com.ProyectoGrupo6.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoDao productoDao;
    @Override
    
    public List<Producto> getProducto(String codigo) {
       List <Producto> productos=productoDao.findAll();
           for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getCodigoProducto()!=codigo){
                productos.remove(i);
            }
            
        }
           return productos;
    }

    @Override
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getCodigoProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

}
