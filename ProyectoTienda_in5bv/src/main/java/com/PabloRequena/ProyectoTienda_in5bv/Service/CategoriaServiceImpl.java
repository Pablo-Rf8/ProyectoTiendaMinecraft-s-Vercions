package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Categoria;
import com.PabloRequena.ProyectoTienda_in5bv.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository repo;
    public CategoriaServiceImpl(CategoriaRepository repo) { this.repo = repo; }

    @Override
    public List<Categoria> listar() { return repo.findAll(); }
    @Override
    public Categoria obtenerPorId(Integer id) { return repo.findById(id).orElse(null); }
    @Override
    public Categoria crearOCrear(Categoria categoria) { return repo.save(categoria); }
    @Override
    public void eliminar(Integer id) { repo.deleteById(id); }
}