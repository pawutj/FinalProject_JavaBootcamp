package finalproject.cashtracking.qrcode.repositories;

import finalproject.cashtracking.qrcode.entities.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    Optional<QRCode> findByValue(String value);
}
