package levi9.VehicleService.service;

import levi9.VehicleService.dto.FinishRentDto;
import levi9.VehicleService.dto.RentDto;
import levi9.VehicleService.dto.RentedVehicleDto;

import java.util.List;

public interface RentService {
    boolean isVehicleRented(Long vehicleId);

    RentedVehicleDto getCurrentlyRentedVehicle(Long clientId);

    void finishRent(FinishRentDto finishRent);

    List<RentDto> getRentHistory(Long clientId);
}
