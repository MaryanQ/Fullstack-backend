package edu.fullstackbackend.Participant;

import edu.fullstackbackend.Entity.Participant;
import edu.fullstackbackend.Repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
@Rollback
public class ParticipantRepositoryTest {

    @Autowired

    private ParticipantRepository participantRepository;

    // Test af oprettelse af deltagere
    @Test
    public void findAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        assertThat(participants).isNotEmpty(); // Tjekker om listen er tom
        assertThat(participants.size()).isEqualTo(8); // Tjekker om listen indeholder 8 deltagere

    }

    @Test
    public void findByName() {
        List<Participant> participants = participantRepository.findByNameContaining("John Doe");
        assertThat(participants).isNotEmpty(); // Tjekker om listen er tom
        assertThat(participants.get(0).getName()).isEqualTo("John Doe"); // Tjekker om navnet på den første deltager er "John Doe"
    }

    @Test
    public void findByGender() {
        List<Participant> participants = participantRepository.findByGender("Female");
        assertThat(participants).isNotEmpty(); // Tjekker om listen er tom
        assertThat(participants.size()).isEqualTo(4); // Tjekker om listen indeholder 4 kvindelige deltagere
    }

    @Test
    public void findByAge() {
        List<Participant> participants = participantRepository.findByAge(25);
        assertThat(participants).isNotEmpty(); // Tjekker om listen er tom
        assertThat(participants.get(0).getAge()).isEqualTo(25); // Tjekker om alderen på den første deltager er 25
    }

    @Test
    public void findByClub() {
        List<Participant> participants = participantRepository.findByClubContaining("Local Club");
        assertThat(participants).isNotEmpty(); // Tjekker om listen er tom
        assertThat(participants.get(0).getClub()).isEqualTo("Local Club"); // Tjekker om klubben på den første deltager er "Local Club"
    }
}


