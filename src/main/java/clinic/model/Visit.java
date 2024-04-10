package clinic.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date visitDate;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
}
