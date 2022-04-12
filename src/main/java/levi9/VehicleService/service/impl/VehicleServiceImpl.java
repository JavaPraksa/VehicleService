package levi9.VehicleService.service.impl;

import levi9.VehicleService.dto.VehicleDto;
import levi9.VehicleService.model.Vehicle;
import levi9.VehicleService.repository.VehicleRepository;
import levi9.VehicleService.service.RentService;
import levi9.VehicleService.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;
    private RentService rentService;
    private final ModelMapper mapper;

    @Override
    public List<VehicleDto> findAvailableVehicles() {
        List<VehicleDto> availableVehicles = new ArrayList<>();
        for(Vehicle v : vehicleRepository.findAll()){
            if(!rentService.isVehicleRented(v.getId()))
                availableVehicles.add(mapper.map(v, VehicleDto.class));
        }
        return  availableVehicles;
    }

    @Override
    @Transactional
    public VehicleDto getVehicleById(Long id){
        return mapper.map(vehicleRepository.getByIdLock(id),VehicleDto.class);
    }

    @Override
    public VehicleDto updateVehicleById(Long id,VehicleDto vehicleDetails){
        Vehicle oldVehicle = vehicleRepository.getByIdLock(id);

        oldVehicle.setDetails(vehicleDetails.getDetails());
        oldVehicle.setAddress(vehicleDetails.getAddress());
        oldVehicle.setModel(vehicleDetails.getModel());
        oldVehicle.setPrice(vehicleDetails.getPrice());

        Vehicle newVehicle = vehicleRepository.save(oldVehicle);

        return mapper.map(newVehicle,VehicleDto.class);


    }

}
