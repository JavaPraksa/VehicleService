package levi9.VehicleService.service;

import levi9.VehicleService.dto.VehicleDto;
import java.util.List;

public interface VehicleService {
    List<VehicleDto> findAvailableVehicles();
}
