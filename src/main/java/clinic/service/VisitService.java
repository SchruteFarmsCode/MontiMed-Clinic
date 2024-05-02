package clinic.service;

import clinic.model.Visit;
import clinic.repository.VisitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VisitService {
    private final VisitRepository visitRepository;
    private static final Logger logger = LoggerFactory.getLogger(VisitService.class);

    public List<Visit> getAllVisits() {
        logger.info("All Visits");
        return visitRepository.findAll();
    }

    public Visit saveVisit(Visit visit) {
        logger.info("Saving Visit: {}", visit);
        return visitRepository.save(visit);
    }

    public Visit getVisitById(Long id) {
        logger.info("Visit with ID: {}", id);
        return visitRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Visit with ID " + id + " not found"));
    }

    public void deleteVisit(Long id) {
        logger.info("Deleting visit with ID: {}",id);
        visitRepository.deleteById(id);
    }

    public Visit updateVisit(Long id, Visit visit) {
        logger.info("Updating visit with ID: {}", id);
        Visit existingVisit = visitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Visit with ID " + id + " not found"));

        existingVisit.setVisitDate(visit.getVisitDate());
        existingVisit.setPatient(visit.getPatient());
        existingVisit.setDoctor(visit.getDoctor());

        return visitRepository.save(existingVisit);
    }

    public List<Visit> getVisitsByPatientId(Long patientId) {
        logger.info("Getting visits for patient with ID: {}", patientId);
        return visitRepository.findByPatientId(patientId);
    }

    public List<Visit> getVisitByDoctorId(Long doctorId) {
        logger.info("Getting visits for doctor with ID: {}", doctorId);
        return visitRepository.findByDoctorId(doctorId);
    }
}
