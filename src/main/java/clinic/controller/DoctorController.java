package clinic.controller;

import clinic.model.Patient;
import clinic.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class DoctorController {
    private final PatientService patientService;

    @GetMapping("/doctor")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
}
