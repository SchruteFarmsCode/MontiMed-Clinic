package clinic.service;

import clinic.model.Doctor;
import clinic.repository.DoctorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    public static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    public List<Doctor> getAllDoctors() {
        logger.info("All doctors");
        return doctorRepository.findAll();
    }

    public Doctor saveDoctor(Doctor doctor) {
        logger.info("Saving  doctor: {}", doctor);
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(Long id) {
        logger.info("Doctor by ID: {}", id);
        return doctorRepository.findById(id).orElse(null);
    }

    public void deleteDoctor(Long id) {
        logger.info("Deleting doctor with ID: {}", id);
        doctorRepository.deleteById(id);
    }
    public Doctor updateDoctor(Long id, Doctor doctor) {
        logger.info("Updating doctor with ID: {}", id);
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

