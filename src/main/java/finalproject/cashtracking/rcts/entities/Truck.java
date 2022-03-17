package finalproject.cashtracking.rcts.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double latitude;
    private double longitude;

    @OneToOne
    private CashBox cashBox;

}
