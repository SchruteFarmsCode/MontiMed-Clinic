package clinic.controller;

import clinic.model.Patient;
import clinic.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/patients")
@Controller
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatient() {
        log.info("Getting all patients");
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        log.info("Adding a new patient: {}", patient);
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        log.info("Deleting patient with id: {}", id);
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with id " + id + "has been deleted successfully");
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        log.info("Updating patient with id: {}", id);
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatients(@RequestParam(name = "firstName", required = false)
                                                        String firstName,
                                                        @RequestParam(name = "lastName", required = false)
                                                        String lastName) {
        log.info("Searching patients by firstName: {} and lastName: {}", firstName, lastName);
        List<Patient> patients;
        if (firstName != null && lastName != null) {
            patients = patientService.searchPatientByFirstNameAndLastName(firstName, lastName);
        } else if (firstName != null) {
            patients = patientService.searchPatientByFirstName(firstName);
        } else if (lastName != null) {
            patients = patientService.searchPatientByLastName(lastName);
        } else {
            patients = patientService.getAllPatients();
        }
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Patient>> getAllPatientsSorted(@RequestParam(name = "sortBy", defaultValue = "lastName") String sortBy) {
        log.info("Getting all patients sorted by: {}", sortBy);
        List<Patient> patients = patientService.getAllPatientsSortedBy(sortBy);
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

}

