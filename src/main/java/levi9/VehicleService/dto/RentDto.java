package levi9.VehicleService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentDto {
    private String model;
    private double price;
    private int days;

    private String startStreet;
    private String startHouseNumber;
    private String startTown;
    private String startCountry;

    private String endStreet;
    private String endHouseNumber;
    private String endTown;
    private String endCountry;

}
