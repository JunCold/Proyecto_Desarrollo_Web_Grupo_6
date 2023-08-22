package com.ProyectoGrupo6.serviceImpl;

import com.ProyectoGrupo6.dao.ProductoDao;
import com.ProyectoGrupo6.domain.Producto;
import com.ProyectoGrupo6.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> productos = productoDao.findAll();
        if (activos) {
            productos.removeIf(x -> !x.isActivo());
        }

        return productos;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto Producto) {
        return productoDao.findById(Producto.getCodigoProducto()).orElse(null);
    }

    @Override
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(Long codigoProducto) {
        return productoDao.findById(codigoProducto).orElse(null);
    }

    @Override
    @Transactional
    public Producto aumentarProducto(Long codigoProducto, Long cantidadAumentar) {
        Producto producto = productoDao.findById(codigoProducto).orElse(null);

        if (producto != null) {
            producto.setCantidadProducto(producto.getCantidadProducto() + cantidadAumentar);
            return productoDao.save(producto);
        }

        return null; // En caso de no encontrar el producto
    }

    @Override
    @Transactional
    public Producto disminuirProducto(Long codigoProducto, Long cantidadDisminuir) {
        Producto producto = productoDao.findById(codigoProducto).orElse(null);

        if (producto != null) {
            Long nuevaCantidad = producto.getCantidadProducto() - cantidadDisminuir;

            if (nuevaCantidad >= 0) {
                producto.setCantidadProducto(nuevaCantidad);
                return productoDao.save(producto);
            }
        }

        return null; // En caso de no encontrar el producto
    }

}
