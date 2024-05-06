package clinic.service;

import clinic.model.Doctor;
import clinic.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        log.info("All doctors");
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        log.info("Saving  doctor: {}", doctor);
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        log.info("Doctor by ID: {}", id);
        return doctorRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        log.info("Deleting doctor with ID: {}", id);
        doctorRepository.deleteById(id);
    }
    public Doctor updateDoctor(Long id, Doctor doctor) {
        log.info("Updating doctor with ID: {}", id);
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Doctor with ID " + id + " not found"));

        existingDoctor.setFirstName(doctor.getFirstName());
        existingDoctor.setLastName(doctor.getLastName());
        existingDoctor.setAge(doctor.getAge());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setEmail(doctor.getEmail());

        return doctorRepository.save(existingDoctor);
    }
}

