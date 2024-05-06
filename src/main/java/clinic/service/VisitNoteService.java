package clinic.service;

import clinic.model.VisitNote;
import clinic.repository.VisitNoteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VisitNoteService {

    private final VisitNoteRepository visitNoteRepository;

    public List<VisitNote> getAllVisitNotes() {
        log.info("Getting all visit notes");
        return visitNoteRepository.findAll();
    }

    public VisitNote saveVisitNote(VisitNote visitNote) {
        log.info("Saving visit note: {}", visitNote);
        return visitNoteRepository.save(visitNote);
    }

    public VisitNote getVisitNoteById(Long id) {
        log.info("Getting visit note by id: {}", id);
        return visitNoteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("VisitNote with id " + id + " not found"));
    }

    public void deleteVisitNote(Long id) {
        log.info("Deleting visit note with id: {}", id);
        visitNoteRepository.deleteById(id);
    }

}
