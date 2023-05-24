package com.paginacion.paginacion.servicio;

import com.paginacion.paginacion.entidad.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioServicioAPI {

    Page<Usuario> getAll(Pageable pageable);

}
