
package com.ProyectoGrupo6.dao;
import com.ProyectoGrupo6.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    
    public Producto findByCodigoProducto (Long codogoProducto);
}
