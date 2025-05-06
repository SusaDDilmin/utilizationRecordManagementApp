package utilization.staff.staff_utilization_backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import utilization.staff.staff_utilization_backend.model.UtilizationRecord;

import java.util.Optional;

public interface UtilizationRecordRepo extends JpaRepository<UtilizationRecord , Long>{

    void deleteUtilizationRecordById(Long id);

    Optional<UtilizationRecord> findUtilizationRecordById(Long id);

}
