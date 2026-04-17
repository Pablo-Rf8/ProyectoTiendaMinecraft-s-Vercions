// Interfaz
package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    Categoria obtenerPorId(Integer id);
    Categoria crearOCrear(Categoria categoria);
    void eliminar(Integer id);
}
