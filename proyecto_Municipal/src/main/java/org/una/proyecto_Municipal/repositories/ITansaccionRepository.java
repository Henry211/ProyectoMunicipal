package org.una.proyecto_Municipal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.proyecto_Municipal.entities.Transaccion;

public interface ITansaccionRepository extends JpaRepository<Transaccion, Long> {
}
