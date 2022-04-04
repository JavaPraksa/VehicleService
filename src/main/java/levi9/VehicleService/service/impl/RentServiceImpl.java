package levi9.VehicleService.service.impl;

import levi9.VehicleService.dto.FinishRentDto;
import levi9.VehicleService.dto.RentedVehicleDto;
import levi9.VehicleService.exception.BadRequestException;
import levi9.VehicleService.model.Address;
import levi9.VehicleService.model.Rent;
import levi9.VehicleService.model.Vehicle;
import levi9.VehicleService.repository.AddressRepository;
import levi9.VehicleService.repository.RentRepository;
import levi9.VehicleService.repository.VehicleRepository;
import levi9.VehicleService.service.RentService;
import levi9.VehicleService.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;
    private final AddressRepository addressRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public boolean isVehicleRented(Long vehicleId) {
        List<Rent> allRents = rentRepository.findByVehicleId(vehicleId);
        for (Rent r : allRents) {
            if (isRentActive(r))
                return true;
        }
        return false;
    }

    @Override
    public RentedVehicleDto getCurrentlyRentedVehicle(Long clientId) {
        Rent rent = rentRepository.findByClientIdAndEndTimeEquals(clientId, null);
        if (rent == null) {
            throw new BadRequestException("User do not have currently rented vehicle");
        }
        return new RentedVehicleDto(rent.getId(), rent.getVehicle().getModel(), rent.getVehicle().getPrice(), rent.getStartTime(), rent.getStartAddress());
    }

    @Override
    public void finishRent(FinishRentDto finishRent) {
        Rent rent = rentRepository.findById(finishRent.getRentId()).orElseThrow(() -> new BadRequestException("Rent is not found"));
        Address address = addressRepository.findById(finishRent.getAddressId()).orElseThrow(() -> new BadRequestException("Address is not found"));

        rent.setEndTime(LocalDateTime.now());
        rent.setEndAddress(address);
        Vehicle vehicle = rent.getVehicle();
        vehicle.setAddress(address);
        rentRepository.save(rent);
        vehicleRepository.save(vehicle);
    }

    private boolean isRentActive(Rent r) {
        if (r.getEndTime() == null || r.getEndTime().isAfter(LocalDateTime.now()))
            return true;
        return false;
    }
}
