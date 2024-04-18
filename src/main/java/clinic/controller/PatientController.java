package clinic.controller;

import clinic.model.Patient;
import clinic.service.PatientService;
import lombok.AllArgsConstructor;
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

    @GetMapping
    public List<Patient> getAllPatient() {
        return patientService.getAllPatients();
    }

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient with id " + id + "has been deleted successfully");
    }
    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id, patient);
        return ResponseEntity.ok(updatedPatient);
    }
    @GetMapping("/add-patient")
    public String showAddPatientForm() {
        return "add-patient";
    }
}

