package levi9.VehicleService;

import levi9.UserService.api.Example1;
import levi9.UserService.api.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private UserServiceApi userServiceApi;

    @GetMapping(value = "/")
    public String example1() {
        return "vehicle";
    }

    @GetMapping("/user")
    public Example1 example(){
        return userServiceApi.example();
    }
}
