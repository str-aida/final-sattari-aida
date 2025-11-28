package com.talentotech.projectoFinal.repository;

import com.talentotech.projectoFinal.model.Producto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
//buscar producto por nombre:
  Optional<Producto> findByNombre(String nombre);
}
