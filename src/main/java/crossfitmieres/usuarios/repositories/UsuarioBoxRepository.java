package crossfitmieres.usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crossfitmieres.usuarios.models.UsuarioBox;

@Repository
public interface UsuarioBoxRepository extends JpaRepository<UsuarioBox, Long> {
}
