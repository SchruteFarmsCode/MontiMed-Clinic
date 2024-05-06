package clinic.service;

import clinic.model.Patient;
import clinic.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        log.info("All Patients");
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient patient) {
        log.info("Saving patient: {}", this);
        return patientRepository.save(patient);
    }

    public Patient getPatientById(Long patientId) {
        log.info("Patient with ID: {}", patientId);
        return patientRepository.findById(patientId).orElse(null);
    }

    public void deletePatient(Long patientId) {
        log.info("Deleting patient with ID: {}", patientId);
        patientRepository.deleteById(patientId);
    }

    public Patient updatePatient(Long id, Patient patient) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient with id " + id + " not found"));

        log.info("Updating patient with ID {}: {}", id, patient);

        existingPatient.setFirstName(patient.getFirstName());
        existingPatient.setLastName(patient.getLastName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setDateOfBirth(patient.getDateOfBirth());
        existingPatient.setGender(patient.getGender());

        return patientRepository.save(existingPatient);
    }

    public List<Patient> searchPatientByFirstName(String firstName) {
        log.info("Searching patients by firstName: {}", firstName);
        return patientRepository.findByFirstName(firstName);
    }
    public List<Patient> searchPatientByLastName(String lastName) {
        log.info("Searching patients by lastName: {}", lastName);
        return patientRepository.findByLastName(lastName);
    }

    public List<Patient> searchPatientByFirstNameAndLastName(String firstName, String lastName) {
        log.info("Searching patients by firstName: {} and lastName: {}", firstName, lastName);
        return patientRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Patient> getAllPatientsSortedBy(String sortBy) {
        log.info("Getting all patients sorted by: {}", sortBy);
        List<Patient> patients;
        switch(sortBy) {
            case "firstName" -> patients = patientRepository.findAllByOrderByFirstNameAsc();
            case "lastName" -> patients = patientRepository.findAllByOrderByLastNameAsc();
            default -> patients = patientRepository.findAll();
        }
        return patients;
    }

}
