package com.PabloRequena.ProyectoTienda_in5bv.Service;
import com.PabloRequena.ProyectoTienda_in5bv.Entity.Pedido;
import com.PabloRequena.ProyectoTienda_in5bv.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired private PedidoRepository repo;

    @Override public List<Pedido> listar() { return repo.findAll(); }
    @Override public Pedido obtenerPorId(Integer id) { return repo.findById(id).orElse(null); }
    @Override public Pedido guardar(Pedido pedido) { return repo.save(pedido); }
    @Override public void eliminar(Integer id) { repo.deleteById(id); }
}