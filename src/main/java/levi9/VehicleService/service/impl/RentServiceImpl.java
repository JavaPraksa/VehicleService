package levi9.VehicleService.service.impl;

import levi9.VehicleService.model.Rent;
import levi9.VehicleService.repository.RentRepository;
import levi9.VehicleService.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepository rentRepository;

    @Override
    public boolean isVehicleRented(Long vehicleId){
        List<Rent> allRents = rentRepository.findByVehicleId(vehicleId);
        for(Rent r : allRents){
            if (isRentActive(r))
                return true;
        }
        return false;
    }

    private boolean isRentActive(Rent r){
        if (r.getEndTime() == null || r.getEndTime().isAfter(LocalDateTime.now()))
            return true;
        return false;
    }
}
