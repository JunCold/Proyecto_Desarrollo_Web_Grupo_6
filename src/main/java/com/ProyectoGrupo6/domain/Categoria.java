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
    @Column(name = "id_categoria")
    private Long idCategoria;
    private String nombreCategoria;
    private boolean activo;
    private String rutaImagen;
    


    public Categoria() {
    }

    public Categoria(String nombreCategoria, boolean activo, String rutaImagen) {
        this.nombreCategoria = nombreCategoria;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
    }
    
    

   
}
