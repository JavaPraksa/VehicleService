package levi9.VehicleService.repository;

import levi9.VehicleService.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.time.LocalDateTime;
import java.util.List;


public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByVehicleId(Long id);
    Rent findByClientIdAndEndTimeEquals(Long clientId, LocalDateTime endTime);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM Rent r")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "1000")})
    List<Rent> getAllLock();
}
