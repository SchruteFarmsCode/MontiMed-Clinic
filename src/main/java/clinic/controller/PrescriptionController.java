package clinic.controller;

import clinic.model.Prescription;
import clinic.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/prescriptions")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<Prescription> addPrescription(@RequestBody Prescription prescription) {
        log.info("Adding a new prescription: {}", prescription);
        Prescription savedPrescription = prescriptionService.savePrescription(prescription);
        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable Long id) {
        log.info("Getting prescription by ID: {}", id);
        return prescriptionService.getPrescriptionById(id);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deletePrescription(@PathVariable Long id) {
        log.info("Deleting prescription with ID: {}", id);
        prescriptionService.deletePrescription(id);
        return ResponseEntity.ok("Prescription with Id: " + id + " has been deleted successfully");
    }
    @PutMapping("/{id}")
        public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        log.info("Updating prescription with ID: {}", id);
        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescription);
        return ResponseEntity.ok(updatedPrescription);
        }


}
