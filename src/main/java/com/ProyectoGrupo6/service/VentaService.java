
package com.ProyectoGrupo6.service;

import com.ProyectoGrupo6.domain.Venta;
import java.util.List;
public interface VentaService {
    public List<Venta>getVentas();
    public Venta getVenta(Venta venta);
    public void save(Venta venta);
    public void delete(Venta venta);
}
