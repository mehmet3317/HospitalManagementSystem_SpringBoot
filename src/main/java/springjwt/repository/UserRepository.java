package springjwt.repository;

import com.bezkoder.springjwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  List<User> findByRolesIn(Collection<String> names);


  //@Query("select u from User u join Role r where r.name = :name")
  @Query("SELECT user FROM User user LEFT JOIN user.roles role WHERE role.id = ?1")
  List<User> findAllByRoles(@Param("name")int id);

  @Query("SELECT user FROM User user LEFT JOIN user.specializations role WHERE role.id = ?1")
  List<User> findAllBySpecializations(@Param("name")int id);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
