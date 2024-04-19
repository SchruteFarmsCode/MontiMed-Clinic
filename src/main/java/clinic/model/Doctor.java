package clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Entity
public class Doctor {
    private static final Logger logger = LoggerFactory.getLogger(Doctor.class);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String age;
    private String specialization;
    private String email;

    @PrePersist
    public void beforeSave() {
        logger.info("Saving doctor: {}", this);

    }

    @PreRemove
    public void beforeDelete() {
        logger.info("Deleting doctor with id: {}", this.id);
    }

    @PreUpdate
    public void beforeUpdate() {
        logger.info("Updating doctor: {}", this);
    }
}
