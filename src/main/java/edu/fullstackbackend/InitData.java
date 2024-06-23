package edu.fullstackbackend;


import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Entity.Participant;
import edu.fullstackbackend.Repository.DisciplinRepository;
import edu.fullstackbackend.Repository.ParticipantRepository;
import edu.fullstackbackend.Repository.ResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.fullstackbackend.Entity.Result;
import java.time.LocalDate;
import java.util.List;



@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private DisciplinRepository disciplinRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Create participants
        Participant participant1 = new Participant("John Doe", "Male", 25, "Local Club");
        Participant participant2 = new Participant("Jane Smith", "Female", 28, "City Club");
        Participant participant3 = new Participant("Alice Johnson", "Female", 22, "University Club");
        Participant participant4 = new Participant("Bob Brown", "Male", 30, "National Club");
        Participant participant5 = new Participant("Charlie Black", "Male", 27, "Regional Club");
        Participant participant6 = new Participant("Diana White", "Female", 24, "Community Club");
        Participant participant7 = new Participant("Eve Green", "Female", 29, "State Club");
        Participant participant8 = new Participant("Frank Blue", "Male", 26, "International Club");

        // Save participants in the database
        participantRepository.saveAll(List.of(participant1, participant2, participant3, participant4, participant5, participant6, participant7, participant8));

        // Create disciplines
        Disciplin disciplin1 = new Disciplin("100m Sprint", "Time", participant1);
        Disciplin disciplin2 = new Disciplin("Long Jump", "Distance", participant2);
        Disciplin disciplin3 = new Disciplin("High Jump", "Height", participant3);
        Disciplin disciplin4 = new Disciplin("Marathon", "Time", participant4);
        Disciplin disciplin5 = new Disciplin("Shot Put", "Distance", participant5);
        Disciplin disciplin6 = new Disciplin("Discus Throw", "Distance", participant6);
        Disciplin disciplin7 = new Disciplin("Javelin Throw", "Distance", participant7);
        Disciplin disciplin8 = new Disciplin("Pole Vault", "Height", participant8);
        Disciplin disciplin9 = new Disciplin("1500m", "Time", participant1);
        Disciplin disciplin10 = new Disciplin("5000m", "Time", participant2);

        // Save disciplines in the database
        disciplinRepository.saveAll(List.of(disciplin1, disciplin2, disciplin3, disciplin4, disciplin5, disciplin6, disciplin7, disciplin8, disciplin9, disciplin10));

        // Create and save results
        Result result1 = new Result("Time", LocalDate.of(2024, 6, 23), "00:12:34.56", participant1, disciplin1);
        Result result2 = new Result("Distance", LocalDate.of(2024, 6, 23), "5.67", participant2, disciplin2);
        Result result3 = new Result("Height", LocalDate.of(2024, 6, 23), "1.85", participant3, disciplin3);
        Result result4 = new Result("Time", LocalDate.of(2024, 6, 23), "04:05:06.78", participant4, disciplin4);
        Result result5 = new Result("Distance", LocalDate.of(2024, 6, 23), "15.34", participant5, disciplin5);
        Result result6 = new Result("Distance", LocalDate.of(2024, 6, 23), "45.76", participant6, disciplin6);
        Result result7 = new Result("Distance", LocalDate.of(2024, 6, 23), "5.45", participant7, disciplin7);
        Result result8 = new Result("Height", LocalDate.of(2024, 6, 23), "3.20", participant8, disciplin8);
        Result result9 = new Result("Time", LocalDate.of(2024, 6, 23), "04:05:06.78", participant1, disciplin9);
        Result result10 = new Result("Time", LocalDate.of(2024, 6, 23), "14:15:16.17", participant2, disciplin10);

        // Save Result entities in the database
        resultRepository.saveAll(List.of(result1, result2, result3, result4, result5, result6, result7, result8, result9, result10));

        // Link Result entities to Disciplin entities
        disciplin1.setResult(result1);
        disciplin2.setResult(result2);
        disciplin3.setResult(result3);
        disciplin4.setResult(result4);
        disciplin5.setResult(result5);
        disciplin6.setResult(result6);
        disciplin7.setResult(result7);
        disciplin8.setResult(result8);
        disciplin9.setResult(result9);
        disciplin10.setResult(result10);

        // Save updated Disciplin entities in the database
        disciplinRepository.saveAll(List.of(disciplin1, disciplin2, disciplin3, disciplin4, disciplin5, disciplin6, disciplin7, disciplin8, disciplin9, disciplin10));
    }
}
