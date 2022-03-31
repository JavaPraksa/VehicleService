package levi9.VehicleService.service;

import levi9.VehicleService.model.Vehicle;
import java.util.List;

public interface VehicleService {
    public List<Vehicle> findAvailableVehicles();
}
