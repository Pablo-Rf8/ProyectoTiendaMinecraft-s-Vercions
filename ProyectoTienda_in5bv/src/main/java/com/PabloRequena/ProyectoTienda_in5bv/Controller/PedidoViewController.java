package com.PabloRequena.ProyectoTienda_in5bv.Controller;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.Pedido;
import com.PabloRequena.ProyectoTienda_in5bv.Service.PedidoService;
import com.PabloRequena.ProyectoTienda_in5bv.Service.DetallePedidoService;
import com.PabloRequena.ProyectoTienda_in5bv.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/pedidos")
public class PedidoViewController {

    @Autowired private PedidoService pedidoService;
    @Autowired private DetallePedidoService detallePedidoService;
    @Autowired private UsuarioService usuarioService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaPedidos", pedidoService.listar());
        return "pedidos";
    }

    @GetMapping("/nuevo")
    public String nuevoPedido(Model model) {
        Pedido pedido = new Pedido();
        pedido.setFechaPedido(LocalDateTime.now());
        pedido.setTotalPedido(0.0);

        model.addAttribute("pedido", pedido);
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("titulo", "NUEVO TICKET DE COMPRA");
        return "form-pedido";
    }

    // NUEVO: Botón de Editar Ticket
    @GetMapping("/editar/{id}")
    public String editarPedido(@PathVariable Integer id, Model model) {
        model.addAttribute("pedido", pedidoService.obtenerPorId(id));
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("titulo", "MODIFICAR TICKET");
        return "form-pedido";
    }

    @PostMapping("/guardar")
    public String guardarPedido(@ModelAttribute Pedido pedido) {
        if(pedido.getFechaPedido() == null){
            pedido.setFechaPedido(LocalDateTime.now());
        }
        pedidoService.guardar(pedido);
        return "redirect:/pedidos";
    }

    @GetMapping("/{id}/detalles")
    public String verDetalles(@PathVariable Integer id, Model model) {
        Pedido pedido = pedidoService.obtenerPorId(id);
        model.addAttribute("pedido", pedido);
        model.addAttribute("listaDetalles", detallePedidoService.obtenerPorPedido(id));
        return "detalles-pedido";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
        return "redirect:/pedidos";
    }
}