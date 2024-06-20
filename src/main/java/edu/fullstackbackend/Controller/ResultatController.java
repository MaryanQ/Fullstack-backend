package edu.fullstackbackend.Controller;

import edu.fullstackbackend.Entity.Resultat;
import edu.fullstackbackend.Service.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resultat")
public class ResultatController {

    private final ResultatService resultatService;

    @Autowired
    public ResultatController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }

    @GetMapping
    public List<Resultat> getAllResultater() {
        return resultatService.findAllResultater();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultat> getResultatById(@PathVariable Long id) {
        Optional<Resultat> resultat = resultatService.findResultatById(id);
        return resultat.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resultat createResultat(@RequestBody Resultat resultat) {
        return resultatService.saveResultat(resultat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultat> updateResultat(@PathVariable Long id, @RequestBody Resultat resultatDetails) {
        try {
            Resultat updatedResultat = resultatService.updateResultat(id, resultatDetails);
            return ResponseEntity.ok(updatedResultat);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResultat(@PathVariable Long id) {
        try {
            resultatService.deleteResultat(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
