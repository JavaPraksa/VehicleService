package levi9.VehicleService.controller;

import levi9.UserService.api.UserServiceApi;
import levi9.VehicleService.dto.AddressDto;
import levi9.VehicleService.dto.RentedVehicleDto;
import levi9.VehicleService.exception.BadRequestException;
import levi9.VehicleService.service.AddressService;
import levi9.VehicleService.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/rent", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class RentController {
    private final RentService rentService;
    private final AddressService addressService;

    @GetMapping("/currently-rented-vehicle")
    public ResponseEntity<RentedVehicleDto> currentlyRentedVehicle(@RequestParam Long clientId) {
        return ResponseEntity.ok(rentService.getCurrentlyRentedVehicle(clientId));
    }

    @GetMapping("/getAllGarages")
    public ResponseEntity<List<AddressDto>> getAllGarages() {
        return ResponseEntity.ok(addressService.getAllGarages());
    }
}
