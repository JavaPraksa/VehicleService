package levi9.VehicleService.controller;

import levi9.VehicleService.dto.NewRentDto;
import levi9.VehicleService.dto.VehicleDto;
import levi9.VehicleService.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class VehicleSocketController {
    private VehicleService vehicleService;

    @MessageMapping("/rent-change")
    @SendTo("/vehicle-socket/available-vehicles")
    public ResponseEntity<List<VehicleDto>> findAvailableVehicles(){
        return ResponseEntity.ok(vehicleService.findAvailableVehicles());
    }

}
