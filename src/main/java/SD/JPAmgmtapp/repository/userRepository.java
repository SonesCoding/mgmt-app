package SD.JPAmgmtapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.JPAmgmtapp.entity.user;
import java.util.List;


public interface userRepository extends JpaRepository<user, Long> {

    user findById(long id);
    List <user> findByFirstName(String firstName);
   List <user> findByEmailAddress (String emailAddress);
    user findBylastName(String lastName);
    List<user> findByUserRole(String userRole);
    List<user> findByUsername(String username);


        }
