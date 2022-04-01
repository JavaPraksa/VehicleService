package levi9.VehicleService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Long id;
    private String street;
    private String houseNumber;
    private String town;
    private String country;
    private double longitude;
    private double latitude;
}
