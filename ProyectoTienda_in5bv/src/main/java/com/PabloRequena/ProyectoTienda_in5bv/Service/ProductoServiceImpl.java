package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Producto;
import com.PabloRequena.ProyectoTienda_in5bv.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired private ProductoRepository repo;

    @Override public List<Producto> listar() { return repo.findAll(); }
    @Override public Producto obtenerPorId(Integer id) { return repo.findById(id).orElse(null); }
    @Override public Producto guardar(Producto producto) { return repo.save(producto); }
    @Override public void eliminar(Integer id) { repo.deleteById(id); }
}