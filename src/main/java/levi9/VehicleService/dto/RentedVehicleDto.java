package levi9.VehicleService.dto;

import levi9.VehicleService.model.Address;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RentedVehicleDto {
    private Long rentId;
    private String model;
    private double price;
    private LocalDateTime startTime;
    private String street;
    private String houseNumber;
    private String town;
    private String country;
    private double longitude;
    private double latitude;

    public RentedVehicleDto(Long rentId, String model, double price, LocalDateTime startTime, Address address) {
        this.rentId = rentId;
        this.model = model;
        this.price = price;
        this.startTime = startTime;
        this.street = address.getStreet();
        this.houseNumber = address.getHouseNumber();
        this.town = address.getTown();
        this.country = address.getCountry();
        this.longitude = address.getLongitude();
        this.latitude = address.getLatitude();
    }
}
