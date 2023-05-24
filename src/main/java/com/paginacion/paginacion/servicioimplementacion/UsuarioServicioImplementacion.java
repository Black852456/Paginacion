package com.paginacion.paginacion.servicioimplementacion;

import com.paginacion.paginacion.entidad.Usuario;
import com.paginacion.paginacion.repositorio.UsuarioRepositorio;
import com.paginacion.paginacion.servicio.UsuarioServicioAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicioAPI {

    @Autowired
    private UsuarioRepositorio personaRepositorio;

    @Override
    public Page<Usuario> getAll(Pageable pageable) {
        return personaRepositorio.findAll(pageable);
    }
}
