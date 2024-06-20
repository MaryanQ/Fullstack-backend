package edu.fullstackbackend.Controller;

import edu.fullstackbackend.Entity.Deltager;
import edu.fullstackbackend.Service.DeltagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deltager")
public class DeltagerController {

    private final DeltagerService deltagerService;

    @Autowired
    public DeltagerController(DeltagerService deltagerService) {
        this.deltagerService = deltagerService;
    }

    @GetMapping
    public List<Deltager> getAllDeltagere() {
        return deltagerService.findAllDeltagere();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deltager> getDeltagerById(@PathVariable Long id) {
        Optional<Deltager> deltager = deltagerService.findDeltagerById(id);
        return deltager.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Deltager createDeltager(@RequestBody Deltager deltager) {
        return deltagerService.saveDeltager(deltager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deltager> updateDeltager(@PathVariable Long id, @RequestBody Deltager deltagerDetails) {
        try {
            Deltager updatedDeltager = deltagerService.updateDeltager(id, deltagerDetails);
            return ResponseEntity.ok(updatedDeltager);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeltager(@PathVariable Long id) {
        try {
            deltagerService.deleteDeltager(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
