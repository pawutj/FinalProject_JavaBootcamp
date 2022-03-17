package finalproject.cashtracking.qrcode.exceptions;

public class QRCodeNotFoundException extends RuntimeException{
    public QRCodeNotFoundException(String value){
        super(value);
    }
}
