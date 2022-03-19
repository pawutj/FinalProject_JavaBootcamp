package finalproject.cashtracking.rcts.repositories;

import finalproject.cashtracking.rcts.entities.CashBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashBoxRepository extends JpaRepository<CashBox,Long> {
//    Optional<CashBox> findByQRCodeValue(String value);
}
