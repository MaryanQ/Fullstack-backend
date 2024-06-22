package edu.fullstackbackend;


import edu.fullstackbackend.Entity.Participant;
import edu.fullstackbackend.Repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class initData implements CommandLineRunner {

  @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public void run (String... args) throws Exception {
        // Opret  deltagere
        Participant participant1 = new Participant("John Doe", "Male", 25, "Local Club");
        Participant participant2 = new Participant("Jane Smith", "Female", 28, "City Club");
        Participant participant3 = new Participant("Alice Johnson", "Female", 22, "University Club");
        Participant participant4 = new Participant("Bob Brown", "Male", 30, "National Club");
        Participant participant5 = new Participant("Charlie Black", "Male", 27, "Regional Club");
        Participant participant6 = new Participant("Diana White", "Female", 24, "Community Club");
        Participant participant7 = new Participant("Eve Green", "Female", 29, "State Club");
        Participant participant8 = new Participant("Frank Blue", "Male", 26, "International Club");

        // Gem deltagere i databasen
        participantRepository.save(participant1);
        participantRepository.save(participant2);
        participantRepository.save(participant3);
        participantRepository.save(participant4);
        participantRepository.save(participant5);
        participantRepository.save(participant6);
        participantRepository.save(participant7);
        participantRepository.save(participant8);
    }
}