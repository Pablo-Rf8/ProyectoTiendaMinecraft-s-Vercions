package com.PabloRequena.ProyectoTienda_in5bv.Controller;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.Usuario;
import com.PabloRequena.ProyectoTienda_in5bv.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioViewController {

    private final UsuarioService usuarioService;

    public UsuarioViewController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String viewUsuarios(Model model) {
        model.addAttribute("listaUsuarios", usuarioService.listar());
        return "usuarios";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("titulo", "Nuevo Usuario");
        return "form-usuario";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.obtnerePorId(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Editar Usuario");
        return "form-usuario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        if (usuario.getIdUsuario() != null) {
            // Si tiene ID, es una actualización
            usuarioService.actualizar(usuario.getIdUsuario(), usuario);
        } else {
            // Si no tiene ID, es uno nuevo
            usuarioService.crear(usuario);
        }
        return "redirect:/usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
}