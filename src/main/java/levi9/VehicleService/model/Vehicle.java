package levi9.VehicleService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    private Address address;

}
