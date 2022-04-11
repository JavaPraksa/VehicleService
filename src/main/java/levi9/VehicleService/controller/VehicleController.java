package levi9.VehicleService.controller;

import levi9.VehicleService.dto.VehicleDto;
import levi9.VehicleService.model.Vehicle;
import levi9.VehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/available-vehicles")
    public ResponseEntity<List<VehicleDto>> findAvailableVehicles(){
        return ResponseEntity.ok(vehicleService.findAvailableVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id) {
        VehicleDto vehicleDto = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicleDto);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicleById(@PathVariable Long id,@RequestBody VehicleDto vehicleDetails) {
        VehicleDto vehicleDto = vehicleService.updateVehicleById(id,vehicleDetails);
        return ResponseEntity.ok(vehicleDto);
    }




}
