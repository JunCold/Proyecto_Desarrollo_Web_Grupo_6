
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
    private String codigoProducto;
    private String nombreProducto;
    private long cantidadProducto;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombreProducto, long cantidadProducto) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
    }
    
    
}
