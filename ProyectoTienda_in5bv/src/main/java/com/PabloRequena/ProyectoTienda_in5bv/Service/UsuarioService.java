package com.PabloRequena.ProyectoTienda_in5bv.Service;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario obtnerePorId(Integer Id);
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    void eliminar(Integer id);
}