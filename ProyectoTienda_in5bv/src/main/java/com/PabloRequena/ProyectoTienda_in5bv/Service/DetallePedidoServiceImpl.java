package com.PabloRequena.ProyectoTienda_in5bv.Service;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.DetallePedido;
import com.PabloRequena.ProyectoTienda_in5bv.Repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    @Autowired private DetallePedidoRepository repo;

    @Override public List<DetallePedido> obtenerPorPedido(Integer idPedido) { return repo.findByPedido_IdPedido(idPedido); }
    @Override public DetallePedido obtenerPorId(Integer id) { return repo.findById(id).orElse(null); }
    @Override public DetallePedido guardar(DetallePedido detallePedido) { return repo.save(detallePedido); }
    @Override public void eliminar(Integer id) { repo.deleteById(id); }
}