package com.dsge.comicuam.repositorios;

import com.dsge.comicuam.modelos.Suscripcion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SuscripcionRepository extends CrudRepository<Suscripcion, Integer> {

    // Spring Data JDBC arma la consulta sola a partir del nombre del método
    Optional<Suscripcion> findByIdUsuarioAndEstado(Long idUsuario, String estado);
}
