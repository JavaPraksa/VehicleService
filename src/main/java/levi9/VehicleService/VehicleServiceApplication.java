package levi9.VehicleService;
import levi9.UserService.api.UserServiceApi;
import levi9.NotificationService.api.NotificationServiceApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Notification;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = {UserServiceApi.class, NotificationServiceApi.class})
@RestController
public class VehicleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleServiceApplication.class, args);
	}


}
