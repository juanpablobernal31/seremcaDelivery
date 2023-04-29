package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades.rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface rolRepo extends JpaRepository<rol, Integer> {
}
