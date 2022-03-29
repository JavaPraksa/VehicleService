package levi9.VehicleService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long clientId;

    @Column(nullable = false)
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Address startAddress;

    @ManyToOne
    private Address endAddress;


}
