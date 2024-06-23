package edu.fullstackbackend.Service;

import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Entity.Participant;
import edu.fullstackbackend.Entity.Result;
import edu.fullstackbackend.Repository.DisciplinRepository;
import edu.fullstackbackend.Repository.ParticipantRepository;
import edu.fullstackbackend.Repository.ResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private DisciplinRepository disciplinRepository;

    @Transactional
    public Result createResult(String resultType, LocalDate date, String resultValue, Long participantId, Long disciplinId) {
        // Fetch the Disciplin entity in the same transaction
        Disciplin disciplin = disciplinRepository.findById(disciplinId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid disciplinId"));

        // Fetch the Participant entity in the same transaction
        Participant participant = participantRepository.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid participantId"));

        // Create and save the Result entity
        Result result = new Result(resultType, date, resultValue, participant, disciplin);

        // Save the Result entity first
        result = resultRepository.save(result);

        // Set the Result entity to the Disciplin entity
        disciplin.setResult(result);

        // Save the updated Disciplin entity
        disciplinRepository.save(disciplin);

        return result;
    }

    public List<Result> createResultsForDiscipline(List<Result> results) {
        return resultRepository.saveAll(results);
    }

    public List<Result> getAllResultsForDiscipline(Long disciplinId) {
        return resultRepository.findByDisciplinIdOrderByResultValueAsc(disciplinId);
    }

    public List<Result> getResultsForDisciplineAndGender(Long disciplinId, String gender) {
        return resultRepository.findByDisciplinIdAndParticipantGenderOrderByResultValueAsc(disciplinId, gender);
    }

    public List<Result> getResultsForDisciplineAndAgeRange(Long disciplinId, Integer minAge, Integer maxAge) {
        return resultRepository.findByDisciplinIdAndParticipantAgeBetweenOrderByResultValueAsc(disciplinId, minAge, maxAge);
    }

    public Result updateResult(Long resultId, String resultValue) {
        Result result = resultRepository.findById(resultId)
                .orElseThrow(() -> new RuntimeException("Result not found"));
        result.setResultValue(resultValue);
        return resultRepository.save(result);
    }

    public void deleteResult(Long resultId) {
        resultRepository.deleteById(resultId);
    }
}
