package levi9.VehicleService.repository;

import levi9.VehicleService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
