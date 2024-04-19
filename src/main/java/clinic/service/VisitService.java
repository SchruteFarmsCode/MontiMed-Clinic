package clinic.service;

import clinic.model.Visit;
import clinic.repository.VisitRepository;
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
        return visitRepository.findById(id).orElse(null);
    }

    public void deleteVisit(Long id) {
        logger.info("Deleting visit with ID: {}",id);
        visitRepository.deleteById(id);
    }
}
