package levi9.VehicleService.dto;

import levi9.VehicleService.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDto {
    private Long id;
    private String model;
    private String details;
    private double price;
    private Address address;
}
