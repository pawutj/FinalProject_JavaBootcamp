package finalproject.cashtracking.rcts.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;
}
