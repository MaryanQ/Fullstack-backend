package edu.fullstackbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.fullstackbackend.Entity.Result;
import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByDisciplinIdOrderByResultValueAsc(Long disciplinId);
    List<Result> findByDisciplinIdAndParticipantGenderOrderByResultValueAsc(Long disciplinId, String gender);
    List<Result> findByDisciplinIdAndParticipantAgeBetweenOrderByResultValueAsc(Long disciplinId, Integer minAge, Integer maxAge);
}
