package clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Data
@Entity
public class Visit {
    public static final Logger logger = LoggerFactory.getLogger(Visit.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date visitDate;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
    @PrePersist
    public void beforeSave() {
        logger.info("Saving visit: {}", this);
    }
    @PreRemove
    public void beforeDelete() {
        logger.info("Deleting visit with id: {}", this.id);
    }
    @PreUpdate
    public void beforeUpdate() {
        logger.info("Updating visit: {}", this);

    }
}
