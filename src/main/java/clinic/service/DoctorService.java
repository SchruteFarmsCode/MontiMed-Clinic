package clinic.service;

import clinic.model.Doctor;
import clinic.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoctorService {
    public static final Logger logger = LoggerFactory.getLogger(DoctorService.class);
    private final DoctorRepository doctorRepository;

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
}

