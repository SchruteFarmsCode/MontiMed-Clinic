package clinic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Entity
@Data
@Slf4j
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private Date dateOfBirth;
    private String gender;
    @PrePersist
    public void beforeSave() {
        log.info("Saving patient: {}", this);

    }
    @PreRemove
    public void beforeDelete() {
        log.info("Deleting patient with id: {}", this.id);

    }
    @PreUpdate
    public void beforeUpdate() {
        log.info("Updating patient: {}", this);

    }


}
