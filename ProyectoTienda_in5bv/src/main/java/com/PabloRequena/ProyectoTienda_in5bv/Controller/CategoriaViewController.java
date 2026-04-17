package com.PabloRequena.ProyectoTienda_in5bv.Controller;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.Categoria;
import com.PabloRequena.ProyectoTienda_in5bv.Service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaViewController {

    private final CategoriaService service;
    public CategoriaViewController(CategoriaService service) { this.service = service; }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaCategorias", service.listar());
        return "categorias"; // Llama al HTML
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("titulo", "NUEVA CATEGORIA");
        return "form-categoria";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        model.addAttribute("categoria", service.obtenerPorId(id));
        model.addAttribute("titulo", "EDITAR CATEGORIA");
        return "form-categoria";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("categoria") Categoria categoria) {
        service.crearOCrear(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/categorias";
    }
}