package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.DetallePedido;
import java.util.List;

public interface DetallePedidoService {
    List<DetallePedido> obtenerPorPedido(Integer idPedido);
    DetallePedido obtenerPorId(Integer id);
    DetallePedido guardar(DetallePedido detallePedido);
    void eliminar(Integer id);
}