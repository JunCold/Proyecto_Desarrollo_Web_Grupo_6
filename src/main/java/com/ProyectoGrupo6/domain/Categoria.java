package com.ProyectoGrupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_categoria")
    private Long codigoCategoria;
    private String nombreCategoria;
    private long cantidadCategoria;
    private boolean activo;
    private String rutaImagen;
    
     @OneToMany
    @JoinColumn(name = "codigo_categoria")
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(Long codigoCategoria, String nombreCategoria, long cantidadCategoria, boolean activo, String rutaImagen) {
        this.codigoCategoria = codigoCategoria;
        this.nombreCategoria = nombreCategoria;
        this.cantidadCategoria = cantidadCategoria;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
    }
}
