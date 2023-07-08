package crossfitmieres.users.repositories;

import crossfitmieres.users.models.BoxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxUsersRepository extends JpaRepository<BoxUser, Long> {
}
