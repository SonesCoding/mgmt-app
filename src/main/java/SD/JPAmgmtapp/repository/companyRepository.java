package SD.JPAmgmtapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.JPAmgmtapp.entity.company;
import SD.JPAmgmtapp.entity.user;
import java.util.List;


public interface companyRepository extends JpaRepository<company, Long> {

    user findById(long id);
    List <company> findByname(String name);

        }