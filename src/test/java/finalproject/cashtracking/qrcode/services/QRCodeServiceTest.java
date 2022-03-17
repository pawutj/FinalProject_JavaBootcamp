package finalproject.cashtracking.qrcode.services;

import finalproject.cashtracking.qrcode.entities.QRCode;
import finalproject.cashtracking.qrcode.entities.QRCodeType;
import finalproject.cashtracking.qrcode.repositories.QRCodeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QRCodeServiceTest {

    @Mock
    private QRCodeRepository qrCodeRepository;

    @Mock
    private GenerateRandomService generateRandomService;

    @Test
    void findQRCodeByValue() {
        QRCode qrCode = new QRCode();
        qrCode.setValue("ABCDEF");
        qrCode.setQrCodeType(QRCodeType.RTCS);
        when(qrCodeRepository.findByValue("ABCDEF")).thenReturn(Optional.of(qrCode));

        QRCodeService qrCodeService= new QRCodeService();
        qrCodeService.setQrCodeRepository(qrCodeRepository);
        QRCode result = qrCodeService.findQRCodeByValue("ABCDEF");

        assertEquals(result.getValue(),"ABCDEF");
        assertEquals(result.getQrCodeType(),QRCodeType.RTCS);

    }

    @Test
    void createQRCode() {
        QRCode qrCode = new QRCode();
        qrCode.setQrCodeType(QRCodeType.RTCS);
        qrCode.setValue("ABCDEF");
        when(generateRandomService.generateRandomBase64Token(6)).thenReturn("ABCDEF");
        when(qrCodeRepository.save(qrCode)).thenReturn(qrCode);

        QRCodeService qrCodeService = new QRCodeService();
        qrCodeService.setQrCodeRepository(qrCodeRepository);
        qrCodeService.setGenerateRandomService(generateRandomService);
        QRCode result = qrCodeService.createQRCode(QRCodeType.RTCS);

        assertEquals(result.getQrCodeType(),QRCodeType.RTCS);
        assertEquals(result.getValue(),"ABCDEF");

    }
}