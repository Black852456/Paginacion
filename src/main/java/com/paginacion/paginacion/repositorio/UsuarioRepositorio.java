package com.paginacion.paginacion.repositorio;

import com.paginacion.paginacion.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {

}
