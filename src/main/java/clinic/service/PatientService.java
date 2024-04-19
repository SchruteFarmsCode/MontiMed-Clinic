package clinic.service;

import clinic.model.Patient;
import clinic.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    public List<Patient> getAllPatients() {
        logger.info("All Patients");
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient) {
        logger.info("Saving patient: {}", this);
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long patientId) {
        logger.info("Patient with ID: {}", patientId);
        return patientRepository.findById(patientId).orElse(null);
    }

    public void deletePatient(Long patientId) {
        logger.info("Deleting patient with ID: {}",patientId);
        patientRepository.deleteById(patientId);
    }

    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient with id " + id + " not found"));

        logger.info("Updating patient with ID {}: {}", id, patient);

        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        existingPatient.setGender(patient.getGender());

        return patientRepository.save(existingPatient);

    }
}
