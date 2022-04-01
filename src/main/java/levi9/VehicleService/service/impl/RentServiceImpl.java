package levi9.VehicleService.service.impl;

import levi9.VehicleService.dto.RentedVehicleDto;
import levi9.VehicleService.exception.BadRequestException;
import levi9.VehicleService.model.Rent;
import levi9.VehicleService.repository.RentRepository;
import levi9.VehicleService.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentServiceImpl implements RentService {
    private final RentRepository rentRepository;

    @Override
    public boolean isVehicleRented(Long vehicleId){
        List<Rent> allRents = rentRepository.findByVehicleId(vehicleId);
        for(Rent r : allRents){
            if (isRentActive(r))
                return true;
        }
        return false;
    }

    @Override
    public RentedVehicleDto getCurrentlyRentedVehicle(Long clientId) {
        Rent rent = rentRepository.findByClientIdAndEndTimeEquals(clientId, null);
        if(rent == null){
            throw new BadRequestException("User do not have currently rented vehicle");
        }
        return new RentedVehicleDto(rent.getId(), rent.getVehicle().getModel(), rent.getVehicle().getPrice(), rent.getStartTime(), rent.getStartAddress());
    }

    private boolean isRentActive(Rent r){
        if (r.getEndTime() == null || r.getEndTime().isAfter(LocalDateTime.now()))
            return true;
        return false;
    }
}
