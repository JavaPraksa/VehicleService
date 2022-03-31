package levi9.VehicleService.controller;

import levi9.VehicleService.model.Vehicle;
import levi9.VehicleService.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vehicle", produces = MediaType.APPLICATION_JSON_VALUE)
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/available-vehicles")
    public ResponseEntity<List<Vehicle>> findAvailableVehicles(){
        return ResponseEntity.ok(vehicleService.findAvailableVehicles());
    }


}
