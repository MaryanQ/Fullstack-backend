package edu.fullstackbackend.Controller;

import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Entity.Participant;
import edu.fullstackbackend.Service.DisciplinService;
import edu.fullstackbackend.Service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    private DisciplinService disciplinService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping
    public List<Participant> getAllParticipants() {
        return participantService.getParticipants();
    }

    @GetMapping("/{id}")
    public Optional<Participant> getParticipantById(@PathVariable Long id) {
        return participantService.getParticipantsById(id);
    }

    @PostMapping
    public Participant saveParticipant(@RequestBody Participant participant) {
        return participantService.saveParticipant(participant);
    }

    @PutMapping("/{id}")
    public Participant updateParticipant(@PathVariable Long id, @RequestBody Participant updatedParticipant) {
        return participantService.updateParticipant(id, updatedParticipant);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
    }

    @GetMapping("/filter")
    public List<Participant> filterParticipants(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) String club
    ) {
        return participantService.filterParticipants(name, gender, minAge, club);
    }

    @GetMapping("/disciplines")
    public List<Disciplin> getAllDisciplines() {
        return disciplinService.getAllDisciplines();
    }

    @PostMapping("/disciplines")
    public Disciplin createDisciplin(@RequestBody Disciplin disciplin) {
        return disciplinService.saveDisciplin(disciplin);
    }
}
