package levi9.VehicleService.repository;

import levi9.VehicleService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;


public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByVehicleId(Long id);
    Rent findByClientIdAndEndTimeEquals(Long clientId, LocalDateTime endTime);
}
