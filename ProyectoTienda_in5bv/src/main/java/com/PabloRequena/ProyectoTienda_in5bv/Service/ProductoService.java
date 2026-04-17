package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    Producto obtenerPorId(Integer id);
    Producto guardar(Producto producto);
    void eliminar(Integer id);
}