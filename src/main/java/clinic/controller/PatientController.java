package clinic.controller;

import clinic.model.Patient;
import clinic.service.PatientService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RequestMapping("/patients")
@Controller
public class PatientController {

    private final PatientService patientService;
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @GetMapping
    public List<Patient> getAllPatient() {
        logger.info("Getting all patients");
        return patientService.getAllPatients();
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        logger.info("Adding a new patient: {}", patient);
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        logger.info("Deleting patient with id: {}", id);
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with id " + id + "has been deleted successfully");
    }
    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        logger.info("Updating patient with id: {}", id);
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return ResponseEntity.ok(updatedPatient);
    }
    @GetMapping("/add-patient")
    public String showAddPatientForm() {
        return "add-patient";
    }
}

