package finalproject.cashtracking.rcts.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CashBox {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double cash;

    @OneToOne
    private Truck truck;

    private Long userCreatedId;

}
