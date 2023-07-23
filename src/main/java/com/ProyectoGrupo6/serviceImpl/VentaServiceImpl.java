
package com.ProyectoGrupo6.serviceImpl;
import com.ProyectoGrupo6.dao.VentaDao;
import com.ProyectoGrupo6.domain.Venta;
import com.ProyectoGrupo6.service.VentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService{
    
    @Autowired
    VentaDao ventaDao; 
    
    @Override
    public List<Venta> getVentas() {
        List <Venta> ventas=ventaDao.findAll();
        return ventas;
        
    }

    @Override
    public Venta getVenta(Venta venta) {
        return ventaDao.findById(venta.getNumeroVenta()).orElse(null);
    }

    @Override
    public void save(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    public void delete(Venta venta) {
        ventaDao.delete(venta);
    }
    
}
