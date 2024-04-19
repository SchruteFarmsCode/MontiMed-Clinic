package clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Entity
@Data
public class Patient {
    public static final Logger logger = LoggerFactory.getLogger(Patient.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Date dateOfBirth;
    private String gender;
    @PrePersist
    public void beforeSave() {
        logger.info("Saving patient: {}", this);

    }
    @PreRemove
    public void beforeDelete() {
        logger.info("Deleting patient with id: {}", this.id);

    }
    @PreUpdate
    public void beforeUpdate() {
        logger.info("Updating patient: {}", this);

    }


}
