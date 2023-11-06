package SD.JPAmgmtapp.repository;


import org.springframework.data.repository.CrudRepository;

import SD.JPAmgmtapp.entity.user;
import java.util.List;
import java.util.Optional;


public interface userRepository extends CrudRepository<user, Long> {

    Optional<user> findById(long id);
    List <user> findByFirstName(String FirstName);
   List <user> findByEmailAddress (String EmailAddress);
    user findByLastName(String LastName);
    List<user> findByRole(String UserRole);
    List<user> findByUsername(String Username);
    Object save(Optional<user> newUser);


}