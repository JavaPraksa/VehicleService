package levi9.VehicleService;

import levi9.UserService.api.Example1;
import levi9.UserService.api.UserServiceApi;
import levi9.VehicleService.model.Address;
import levi9.VehicleService.model.Rent;
import levi9.VehicleService.model.Vehicle;
import levi9.VehicleService.repository.AddressRepository;
import levi9.VehicleService.repository.RentRepository;
import levi9.VehicleService.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = UserServiceApi.class)
@RestController
public class VehicleServiceApplication implements CommandLineRunner {

	private AddressRepository addressRepository;
	private RentRepository rentRepository;
	private VehicleRepository vehicleRepository;
	@Autowired
	public VehicleServiceApplication(AddressRepository addressRepository, RentRepository rentRepository, VehicleRepository vehicleRepository){
		this.addressRepository = addressRepository;
		this.rentRepository = rentRepository;
		this.vehicleRepository = vehicleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(VehicleServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address1 = new Address(Long.parseLong("1", 10), "Street1", "4a", "Town1", "Country1", 531, 7512);
		addressRepository.save(address1);
		Address address2 = new Address(Long.parseLong("2", 10), "Street2", "4a", "Town Name", "State2", 531, 7512);
		addressRepository.save(address2);
		Address address3 = new Address(Long.parseLong("3", 10), "Street3", "4a", "Town3", "Country3 Name", 531, 7512);
		addressRepository.save(address3);
		Address address4 = new Address(Long.parseLong("4", 10), "Street Name", "8", "City", "State", 531, 7512);
		addressRepository.save(address4);


		Vehicle v1 = new Vehicle(Long.parseLong("1", 10), "Model", "Details hgdskjck hsc g scjkc kjckh", 12, address1);
		Vehicle v2 = new Vehicle(Long.parseLong("2", 10), "Model Name", "Details hgh", 12, address2);
		Vehicle v3 = new Vehicle(Long.parseLong("3", 10), "Model3", "Details ck hscjkc kjckh", 12, address1);
		Vehicle v4 = new Vehicle(Long.parseLong("4", 10), "Model463", "Details hgdskjck hsc g scjkc kjcgdfgf r ggfdgfd d fd dfgfkh", 12, address4);
		vehicleRepository.save(v1);
		vehicleRepository.save(v2);
		vehicleRepository.save(v3);
		vehicleRepository.save(v4);


		LocalDateTime sDateTime = LocalDateTime.of(2022, Month.MARCH, 29, 19, 30, 40);
		LocalDateTime eDateTime = LocalDateTime.of(2022, Month.APRIL, 2, 19, 30, 40);
		LocalDateTime spDateTime = LocalDateTime.of(2021, Month.MARCH, 29, 19, 30, 40);
		LocalDateTime epDateTime = LocalDateTime.of(2021, Month.APRIL, 2, 19, 30, 40);

		Rent r1 = new Rent(Long.parseLong("1", 10), Long.parseLong("2", 10), sDateTime ,eDateTime, v1, address1, null);
		Rent r2 = new Rent(Long.parseLong("2", 10), Long.parseLong("2", 10), spDateTime ,epDateTime, v3, address3, address2);
		//rentRepository.save(r1);
		//rentRepository.save(r2);
	}

}
