package finalproject.cashtracking.qrcode.services;

import finalproject.cashtracking.qrcode.entities.QRCode;
import finalproject.cashtracking.qrcode.entities.QRCodeType;
import finalproject.cashtracking.qrcode.exceptions.QRCodeNotFoundException;
import finalproject.cashtracking.qrcode.repositories.QRCodeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Optional;

@Service
@Setter
public class QRCodeService {
    @Autowired
    QRCodeRepository qrCodeRepository;


    @Autowired
    GenerateRandomService generateRandomService;

    public QRCode findQRCodeByValue(String value){
        Optional<QRCode> qrCodeOptional = qrCodeRepository.findByValue(value);
        if(qrCodeOptional.isPresent())
            return qrCodeOptional.get();
        else
            throw new QRCodeNotFoundException(value);
    }

    public QRCode createQRCode(QRCodeType qrCodeType){
        String qrCodeValue = generateRandomService.generateRandomBase64Token(6);
        QRCode qrCode = new QRCode();
        qrCode.setQrCodeType(qrCodeType);
        qrCode.setValue(qrCodeValue);
        return qrCodeRepository.save(qrCode);
    }

}
