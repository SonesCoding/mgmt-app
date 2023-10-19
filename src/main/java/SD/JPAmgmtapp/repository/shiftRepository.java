package SD.JPAmgmtapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SD.JPAmgmtapp.entity.shift;
import SD.JPAmgmtapp.entity.user;
import java.util.List;


public interface shiftRepository extends JpaRepository<shift, Long> {

    user findById(long id);
    List <shift> findByShiftCompany(String ShiftCompany);
    List<shift> findByShiftStart(String shiftStart);


        }