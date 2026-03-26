package property.pal.bacolod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import property.pal.bacolod.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
