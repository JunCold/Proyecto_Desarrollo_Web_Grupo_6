
package com.ProyectoGrupo6.domain;
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente; 
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private boolean activos;
    public Cliente() {
    }

    public Cliente(String nombre, String correo, String telefono, String direccion, boolean activos) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activos = activos;
    }

 
    
    
}
