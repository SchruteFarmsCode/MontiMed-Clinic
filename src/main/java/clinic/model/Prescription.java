package clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Slf4j
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Visit visit;


    @NonNull
    private String medication;


    @NonNull()
    private Integer dosage;

    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        log.info("Creating new prescription: {}", this);
    }

    public void updatePrescription(Prescription prescription) {
        log.info("Updating prescription: {}", prescription);
        this.medication = prescription.getMedication();
        this.dosage = prescription.getDosage();
    }
}
