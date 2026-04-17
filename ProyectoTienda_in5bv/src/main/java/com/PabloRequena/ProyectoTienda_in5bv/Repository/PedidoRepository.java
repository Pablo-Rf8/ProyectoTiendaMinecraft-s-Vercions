package com.PabloRequena.ProyectoTienda_in5bv.Repository;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {}