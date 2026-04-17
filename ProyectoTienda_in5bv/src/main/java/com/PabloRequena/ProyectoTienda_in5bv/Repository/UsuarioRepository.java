package com.PabloRequena.ProyectoTienda_in5bv.Repository;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}