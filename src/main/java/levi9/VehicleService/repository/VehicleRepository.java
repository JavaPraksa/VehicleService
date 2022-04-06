package levi9.VehicleService.repository;

import levi9.VehicleService.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT v FROM Vehicle v WHERE v.id = ?1")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "1000")})
    Vehicle getByIdLock(Long vehicleId);
}
