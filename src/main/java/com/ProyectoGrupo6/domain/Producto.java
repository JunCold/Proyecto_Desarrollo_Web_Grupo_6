
package com.ProyectoGrupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Long codigoProducto;
    private String nombreProducto;
    private long cantidadProducto;
    private boolean activo;
    private String rutaImagen;

    public Producto() {
    }

    public Producto(Long codigoProducto, String nombreProducto, long cantidadProducto, boolean activo, String rutaImagen) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
    }


  

   
    
    
}
