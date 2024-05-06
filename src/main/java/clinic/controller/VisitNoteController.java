package clinic.controller;

import clinic.model.VisitNote;
import clinic.service.VisitNoteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/visit-notes")
@RestController
@Slf4j
public class VisitNoteController {
    private final VisitNoteService visitNoteService;

    @GetMapping
    public List<VisitNote> getAllVisitNotes() {
        log.info("Getting all visit notes");
        return visitNoteService.getAllVisitNotes();
    }

    @PostMapping
    public ResponseEntity<VisitNote> addVisitNote(@RequestBody VisitNote visitNote) {
        log.info("Adding a new visit note: {}", visitNote);
        VisitNote savedVisitNote = visitNoteService.saveVisitNote(visitNote);
        return new ResponseEntity<>(savedVisitNote, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVisitNote(@PathVariable Long id) {
        log.info("Deleting visit note with id: {}", id);
        visitNoteService.deleteVisitNote(id);
        return ResponseEntity.ok("VisitNote with id " + id + " has been deleted successfully");
    }
}
