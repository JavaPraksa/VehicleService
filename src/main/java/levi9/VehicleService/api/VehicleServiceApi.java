package levi9.VehicleService.api;

import levi9.UserService.api.Example1;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "vehicle-service")
public interface VehicleServiceApi {
    @GetMapping(value = "/")
    String example1();
}
