package com.PabloRequena.ProyectoTienda_in5bv.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "precioProducto")
    private Double precioProducto;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;
}