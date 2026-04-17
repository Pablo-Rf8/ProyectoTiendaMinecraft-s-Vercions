package com.PabloRequena.ProyectoTienda_in5bv.Controller;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.DetallePedido;
import com.PabloRequena.ProyectoTienda_in5bv.Service.DetallePedidoService;
import com.PabloRequena.ProyectoTienda_in5bv.Service.PedidoService;
import com.PabloRequena.ProyectoTienda_in5bv.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalles")
public class DetallePedidoViewController {

    @Autowired private DetallePedidoService detalleService;
    @Autowired private PedidoService pedidoService;
    @Autowired private ProductoService productoService;

    @GetMapping("/nuevo/{idPedido}")
    public String nuevoDetalle(@PathVariable Integer idPedido, Model model) {
        DetallePedido detalle = new DetallePedido();
        detalle.setPedido(pedidoService.obtenerPorId(idPedido));

        model.addAttribute("detalle", detalle);
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("titulo", "AGREGAR ÍTEM AL TICKET Nº " + idPedido);
        return "form-detalle";
    }

    @GetMapping("/editar/{id}")
    public String editarDetalle(@PathVariable Integer id, Model model) {
        DetallePedido detalle = detalleService.obtenerPorId(id);
        model.addAttribute("detalle", detalle);
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("titulo", "MODIFICAR ÍTEM DEL TICKET");
        return "form-detalle";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetallePedido detalle) {
        detalleService.guardar(detalle);
        return "redirect:/pedidos/" + detalle.getPedido().getIdPedido() + "/detalles";
    }

    @GetMapping("/eliminar/{idDetalle}/{idPedido}")
    public String eliminar(@PathVariable Integer idDetalle, @PathVariable Integer idPedido) {
        detalleService.eliminar(idDetalle);
        return "redirect:/pedidos/" + idPedido + "/detalles";
    }
}