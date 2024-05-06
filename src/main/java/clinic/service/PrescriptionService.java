package clinic.service;

import clinic.model.Prescription;
import clinic.repository.PrescriptionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;

    public Prescription savePrescription(Prescription prescription) {
        log.info("Saving prescription: {}", prescription);
        return prescriptionRepository.save(prescription);
    }

    public Prescription getPrescriptionById(Long PrescriptionId) {
        log.info("Prescription with ID: {}", PrescriptionId);
        return prescriptionRepository.findById(PrescriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Prescription with ID " + PrescriptionId + " not found"));
    }

    public void  deletePrescription(Long PrescriptionId) {
        log.info("Deleting prescription with ID: {}", PrescriptionId);
        prescriptionRepository.deleteById(PrescriptionId);
    }

    public Prescription updatePrescription(Long PrescriptionId, Prescription prescription) {
        log.info("Updating prescription with ID: {}", PrescriptionId);
        Prescription existingPrescription = prescriptionRepository.findById(PrescriptionId)
                .orElseThrow(() -> new EntityNotFoundException("Prescription with ID " + PrescriptionId + " not found"));


        existingPrescription.updatePrescription(prescription);

        return prescriptionRepository.save(existingPrescription);
    }
}
