package com.PabloRequena.ProyectoTienda_in5bv.Repository;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {}