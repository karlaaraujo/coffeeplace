package com.coffeeplace.cpweb.persistencia.repositorios;

import com.coffeeplace.cpweb.persistencia.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio
        extends CrudRepository<Usuario, Long> {
    List<Usuario> findAll();
}
