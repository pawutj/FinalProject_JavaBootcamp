package finalproject.cashtracking.rcts.repositories;

import finalproject.cashtracking.rcts.entities.Truck;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TruckRepository extends JpaRepository<Truck,Long> {
    Optional<Truck> findById(Long id);
}
