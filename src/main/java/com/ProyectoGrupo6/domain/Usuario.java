
package com.ProyectoGrupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula")
    private String cedula;
    private String nombreUsuario;
    private String password;
    private String correo;

    public Usuario() {
    }

    public Usuario(String cedula, String nombreUsuario, String password, String correo) {
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.correo = correo;
    }
    
    
    
}
