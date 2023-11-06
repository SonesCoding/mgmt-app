package SD.JPAmgmtapp.repository;


import org.springframework.data.repository.CrudRepository;

import SD.JPAmgmtapp.entity.user;
import java.util.List;
import java.util.Optional;


public interface userRepository extends CrudRepository<user, Long> {

    Optional<user> findById(long id);
    List <user> findByFirstName(String firstName);
   List <user> findByEmailAddress (String emailAddress);
    user findBylastName(String lastName);
    List<user> findByRoles(String userRole);
    List<user> findByUsername(String username);
    Object save(Optional<user> newUser);


}