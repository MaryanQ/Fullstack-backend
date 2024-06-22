package edu.fullstackbackend.Service;

import edu.fullstackbackend.Entity.Participant;
import edu.fullstackbackend.Repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;


    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }

    public Optional<Participant> getParticipantsById(Long id) {
        return participantRepository.findById(id);
    }

    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(Long id, Participant updatedParticipant) {
        return participantRepository.findById(id).map(participant -> {
            participant.setName(updatedParticipant.getName());
            participant.setGender(updatedParticipant.getGender());
            participant.setAge(updatedParticipant.getAge());
            participant.setClub(updatedParticipant.getClub());
            return participantRepository.save(participant);
        }).orElseGet(() -> {
            updatedParticipant.setId(id);
            return participantRepository.save(updatedParticipant);
        });


    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }

    public List<Participant> findByNameContaining(String name) {
        return participantRepository.findByNameContaining(name);

    }

    public List<Participant> findByClubContaining(String club) {
        return participantRepository.findByClubContaining(club);
    }

    public List<Participant> findByGender(String gender) {
        return participantRepository.findByGender(gender);

    }
public List<Participant> findByAge(int age) {
        return participantRepository.findByAge(age);
    }

    public List<Participant> filterParticipants(String name, String gender, Integer age, String club) {
        if (name != null && gender != null && age != null && club != null) {
            return participantRepository.findByNameAndGenderAndAgeAndClub(name, gender, age, club);
        } else if (name != null && gender != null && age != null) {
            return participantRepository.findByNameAndGenderAndAgeGreaterThan(name, gender, age);
        } else if (name != null && gender != null) {
            return participantRepository.findByNameAndGender(name, gender);
        } else if (name != null) {
            return participantRepository.findByNameContaining(name);
        } else if (gender != null) {
            return participantRepository.findByGender(gender);
        } else if (age != null) {
            return participantRepository.findByAge(age);
        } else if (club != null) {
            return participantRepository.findByClubContaining(club);
        } else {
            return participantRepository.findAll();
        }
    }
}