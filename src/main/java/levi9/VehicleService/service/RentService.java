package levi9.VehicleService.service;

import levi9.VehicleService.dto.RentedVehicleDto;

public interface RentService {
    boolean isVehicleRented(Long vehicleId);

    RentedVehicleDto getCurrentlyRentedVehicle(Long clientId);
}
