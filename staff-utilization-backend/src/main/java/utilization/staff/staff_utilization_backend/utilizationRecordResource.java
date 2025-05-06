package utilization.staff.staff_utilization_backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utilization.staff.staff_utilization_backend.model.UtilizationRecord;
import utilization.staff.staff_utilization_backend.service.UtilizationRecordService;

import java.util.List;

// mee thyenne controller eka klin haduwe serice ekata adala ewa saha service eka DB ekata sambanda wena ewa
//Controller eka clientgen ena http request service ekta ywanwa service eken clienet ta ena ewa clienet ta ywanwa
@RestController
@RequestMapping("utilizationRecord")
public class utilizationRecordResource {
    private final UtilizationRecordService utilizationRecordService;

    public utilizationRecordResource(UtilizationRecordService utilizationRecordService) {
        this.utilizationRecordService = utilizationRecordService;
    }

    //Since get method
    @GetMapping("/all")
    public ResponseEntity<List<UtilizationRecord>> getAllUtilizationRecords(){
        List<UtilizationRecord> utilizationRecords = utilizationRecordService.findAllUtilizationRecords();
        return new ResponseEntity<>(utilizationRecords, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UtilizationRecord> getUtilizationRecordById(@PathVariable("id") Long id){
        UtilizationRecord utilizationRecord = utilizationRecordService.findUtilizationRecordById(id);
        return new ResponseEntity<>(utilizationRecord, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UtilizationRecord> addUtilizationRecord(@RequestBody UtilizationRecord utilizationRecord){
        UtilizationRecord newUtilizationRecord = utilizationRecordService.addUtilizationRecord(utilizationRecord);
        return new ResponseEntity<>(newUtilizationRecord, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UtilizationRecord> updateUtilizationRecord(@RequestBody UtilizationRecord utilizationRecord){
        UtilizationRecord updateUtilizationRecord = utilizationRecordService.updateUtilizationRecord(utilizationRecord);
        return new ResponseEntity<>(updateUtilizationRecord, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUtilizationRecord(@PathVariable("id") Long id){
        utilizationRecordService.deleteUtilizationRecord(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
