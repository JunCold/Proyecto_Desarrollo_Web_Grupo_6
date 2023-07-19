package com.ProyectoGrupo6.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_venta")
    private Long numeroVenta;
    private LocalDate fechaVenta;
    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;
    private Long cantidadComprada;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(LocalDate fechaVenta, Producto producto, Long cantidadComprada, Cliente cliente) {
        this.fechaVenta = fechaVenta;
        this.producto = producto;
        this.cantidadComprada = cantidadComprada;
        this.cliente = cliente;
    }
    
    
    
    

}
