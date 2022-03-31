package levi9.VehicleService.service.impl;

import levi9.VehicleService.model.Vehicle;
import levi9.VehicleService.repository.VehicleRepository;
import levi9.VehicleService.service.RentService;
import levi9.VehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private RentService rentService;

    @Override
    public List<Vehicle> findAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for(Vehicle v : vehicleRepository.findAll()){
            if(!rentService.isVehicleRented(v.getId()))
                availableVehicles.add(v);
        }
        return  availableVehicles;
    }
}
