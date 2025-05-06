package utilization.staff.staff_utilization_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utilization.staff.staff_utilization_backend.exception.UserNotFoundException;
import utilization.staff.staff_utilization_backend.model.UtilizationRecord;
import utilization.staff.staff_utilization_backend.repo.UtilizationRecordRepo;

import java.util.List;
import java.util.UUID;

@Service
public class UtilizationRecordService {

    private final UtilizationRecordRepo utilizationRecordRepo;

    @Autowired
    public UtilizationRecordService(UtilizationRecordRepo utilizationRecordRepo){
        this.utilizationRecordRepo = utilizationRecordRepo;
    }

    public UtilizationRecord addUtilizationRecord(UtilizationRecord utilizationRecord){
        utilizationRecord.setStaffCode(UUID.randomUUID().toString());
        return utilizationRecordRepo.save(utilizationRecord);
    }

    public List<UtilizationRecord> findAllUtilizationRecords(){
        return utilizationRecordRepo.findAll();
    }

    public UtilizationRecord updateUtilizationRecord(UtilizationRecord utilizationRecord){
        return utilizationRecordRepo.save(utilizationRecord);
    }

    public UtilizationRecord findUtilizationRecordById(Long id){
        return utilizationRecordRepo.findUtilizationRecordById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUtilizationRecord(Long id){
        utilizationRecordRepo.deleteUtilizationRecordById(id);
    }

}