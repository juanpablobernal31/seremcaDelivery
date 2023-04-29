package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades.municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface municipioRepo extends JpaRepository<municipio, Integer> {
}
