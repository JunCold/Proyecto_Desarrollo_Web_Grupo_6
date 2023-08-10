package com.ProyectoGrupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula_usuario")
    private String cedulaUsuario;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotNull
    private String nombre;
    private String apellidos;
    private String correo;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "cedula_usuario")
    private List<Rol> roles;

}
