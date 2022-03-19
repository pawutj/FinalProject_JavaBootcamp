package finalproject.cashtracking.qrcode.entities;

import finalproject.cashtracking.rcts.entities.CashBox;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class QRCode {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String value;

    @Enumerated(EnumType.STRING)
    private QRCodeType qrCodeType;

    @OneToOne
    private CashBox cashBox;

}
