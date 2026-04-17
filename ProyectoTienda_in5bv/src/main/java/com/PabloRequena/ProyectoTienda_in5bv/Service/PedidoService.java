package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Pedido;
import java.util.List;

public interface PedidoService {
    List<Pedido> listar();
    Pedido obtenerPorId(Integer id);
    Pedido guardar(Pedido pedido);
    void eliminar(Integer id);
}