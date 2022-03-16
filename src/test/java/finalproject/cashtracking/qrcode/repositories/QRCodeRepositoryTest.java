package finalproject.cashtracking.qrcode.repositories;

import finalproject.cashtracking.qrcode.entities.QRCode;
import finalproject.cashtracking.qrcode.entities.QRCodeType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class QRCodeRepositoryTest {

    @Autowired
    private QRCodeRepository qrCodeRepository;

    @Test
    void findByValueIsSuccess() {
        QRCode qrCode= new QRCode();
        qrCode.setValue("000000");
        qrCode.setQrCodeType(QRCodeType.RTCS);

        qrCodeRepository.save(qrCode);
        Optional<QRCode> result = qrCodeRepository.findByValue("000000");

        assertTrue(result.isPresent());
        assertEquals(result.get().getValue() , "000000");
        assertEquals(result.get().getQrCodeType(),QRCodeType.RTCS);

    }

    @Test
    void findByValueIsFail() {
        QRCode qrCode= new QRCode();
        qrCode.setValue("000000");
        qrCode.setQrCodeType(QRCodeType.RTCS);

        qrCodeRepository.save(qrCode);
        Optional<QRCode> result = qrCodeRepository.findByValue("000001");

        assertFalse(result.isPresent());
    }

}