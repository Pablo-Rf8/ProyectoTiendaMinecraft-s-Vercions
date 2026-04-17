package com.PabloRequena.ProyectoTienda_in5bv.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Integer idPedido;

    @Column(name = "fechaPedido")
    private LocalDateTime fechaPedido;

    @Column(name = "totalPedido")
    private Double totalPedido;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
