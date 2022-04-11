package levi9.VehicleService.controller;

import levi9.NotificationService.api.NotificationServiceApi;
import levi9.UserService.api.UserServiceApi;

import levi9.VehicleService.dto.AddressDto;
import levi9.VehicleService.dto.FinishRentDto;
import levi9.VehicleService.dto.RentDto;
import levi9.VehicleService.dto.RentedVehicleDto;
import levi9.VehicleService.exception.BadRequestException;
import levi9.VehicleService.service.AddressService;import levi9.VehicleService.service.RentService;
import levi9.VehicleService.dto.NewRentDto;
import levi9.VehicleService.model.Rent;
import levi9.VehicleService.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/rent", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RentController {
    private final RentService rentService;
    private final AddressService addressService;
    private final VehicleService vehicleService;

    @Autowired
    private UserServiceApi userServiceApi;

    @Autowired
    private NotificationServiceApi notificationServiceApi;



    @GetMapping("/currently-rented-vehicle")
    public ResponseEntity<RentedVehicleDto> currentlyRentedVehicle(@RequestParam Long clientId) {
        return ResponseEntity.ok(rentService.getCurrentlyRentedVehicle(clientId));
    }

    @GetMapping("/garages")
    public ResponseEntity<List<AddressDto>> getAllGarages() {
        return ResponseEntity.ok(addressService.getAllGarages());
    }

    @PutMapping("/finish")
    public ResponseEntity<Void> finishRent(@RequestBody FinishRentDto finishRentDto) {
        rentService.finishRent(finishRentDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> rentVehicle(@RequestBody NewRentDto rentDto) {
        String  loggedUserEmail = userServiceApi.getUserEmailById(rentDto.getClientId());
        String vehicleModel = vehicleService.getVehicleById(rentDto.getVehicleId()).getModel();

        notificationServiceApi.sendsesMessageRenting(loggedUserEmail,rentDto.getVehicleId(),vehicleModel);

        return ResponseEntity.ok(rentService.rentVehicle(rentDto));
    }
  
    @GetMapping("/history")
    public ResponseEntity<List<RentDto>> getRentHistory(@RequestParam Long clientId) {
        return ResponseEntity.ok(rentService.getRentHistory(clientId));
    }
}
