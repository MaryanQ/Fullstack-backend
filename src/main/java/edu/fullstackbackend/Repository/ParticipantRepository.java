package edu.fullstackbackend.Repository;

import edu.fullstackbackend.Entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    List<Participant> findByNameContaining(String name);
    List<Participant> findByClubContaining(String club);
    List<Participant> findByGender(String Gender);
    List<Participant> findByAge(int age); // This is the method that is used to find the participants by age
    List<Participant> findByNameAndGenderAndAgeAndClub(String name, String gender, int age, String club);
    List<Participant> findByNameAndGenderAndAgeGreaterThan(String name, String gender, int age);
    List<Participant> findByNameAndGender(String name, String gender);



}
