package com.PabloRequena.ProyectoTienda_in5bv.Service;

import com.PabloRequena.ProyectoTienda_in5bv.Entity.Usuario;
import com.PabloRequena.ProyectoTienda_in5bv.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtnerePorId(Integer Id) {
        return usuarioRepository.findById(Id).orElseThrow(() -> new RuntimeException("Usuario con Id erroneo"));
    }

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombreUsu(usuario.getNombreUsu());
            usuarioExistente.setApellidoUsu(usuario.getApellidoUsu());
            usuarioExistente.setEdadUsu(usuario.getEdadUsu());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}