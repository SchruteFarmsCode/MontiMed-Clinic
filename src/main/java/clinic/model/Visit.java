package clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Slf4j
@NoArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date visitDate;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL)
    private List<Prescription> prescriptions = new ArrayList<>();

    @PrePersist
    public void beforeSave() {
        log.info("Saving visit: {}", this);
    }

    @PreRemove
    public void beforeDelete() {
        log.info("Deleting visit with id: {}", this.id);
    }

    @PreUpdate
    public void beforeUpdate() {
        log.info("Updating visit: {}", this);

    }
}
