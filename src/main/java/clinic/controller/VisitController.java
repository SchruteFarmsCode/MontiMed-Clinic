package clinic.controller;

import clinic.model.Visit;
import clinic.service.VisitService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/visits")
@Controller
public class VisitController {
    private final VisitService visitService;
    private static final Logger logger = LoggerFactory.getLogger(VisitController.class);

    @GetMapping
    public List<Visit> getAllVisits() {
        logger.info("Getting all visits");
        return visitService.getAllVisits();
    }
    @PostMapping
    public ResponseEntity<Visit> addVisit(@RequestBody Visit visit) {
        logger.info("Adding a new visit: {}", visit);
        Visit savedVisit = visitService.saveVisit(visit);
        return  new ResponseEntity<>(savedVisit, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVisit(@PathVariable Long id) {
        logger.info("Deleting visit with id: {}", id);
        visitService.deleteVisit(id);
        return ResponseEntity.ok("Visit with id " + id + " has been deleted successfully");
    }

    @PutMapping("visits/{id}")
    public ResponseEntity<Visit>  updateVisit(@PathVariable Long id, @RequestBody Visit visit) {
        logger.info("Updating visit with id: {}", id);
        Visit updatedVisit = visitService.updateVisit(id, visit);
        return ResponseEntity.ok(updatedVisit);
    }

    @GetMapping("/patient/{patientId}")
    public List<Visit> getVisitsByPatientId(@PathVariable Long patientId) {
        logger.info("Getting all visits for patient with id: {}", patientId);
        return visitService.getVisitsByPatientId(patientId);
    }

    @GetMapping("/doctor/{doctorId}")
    public List<Visit> getVisitByDoctorId(@PathVariable Long doctorId) {
        logger.info("Getting all visits for doctor with id: {}", doctorId);
        return visitService.getVisitByDoctorId(doctorId);
    }
}
