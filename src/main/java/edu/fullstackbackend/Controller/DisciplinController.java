package edu.fullstackbackend.Controller;

import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Service.DisciplinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplin")
public class DisciplinController {

    private final DisciplinService disciplinService;

    @Autowired
    public DisciplinController(DisciplinService disciplinService) {
        this.disciplinService = disciplinService;
    }

    @GetMapping
    public List<Disciplin> getAllDiscipliner() {
        return disciplinService.findAllDiscipliner();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplin> getDisciplinById(@PathVariable Long id) {
        Optional<Disciplin> disciplin = disciplinService.findDisciplinById(id);
        return disciplin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Disciplin createDisciplin(@RequestBody Disciplin disciplin) {
        return disciplinService.saveDisciplin(disciplin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplin> updateDisciplin(@PathVariable Long id, @RequestBody Disciplin disciplinDetails) {
        try {
            Disciplin updatedDisciplin = disciplinService.updateDisciplin(id, disciplinDetails);
            return ResponseEntity.ok(updatedDisciplin);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplin(@PathVariable Long id) {
        try {
            disciplinService.deleteDisciplin(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
