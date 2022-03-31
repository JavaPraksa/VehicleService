package levi9.VehicleService.repository;

import levi9.VehicleService.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>  {
}
