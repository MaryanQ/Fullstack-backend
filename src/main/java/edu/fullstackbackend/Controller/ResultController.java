package edu.fullstackbackend.Controller;

import edu.fullstackbackend.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.fullstackbackend.Entity.Result;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @PostMapping
    public Result createResult(@RequestParam String resultType,
                               @RequestParam LocalDate date,
                               @RequestParam String resultValue,
                               @RequestParam Long participantId,
                               @RequestParam Long disciplinId) {
        return resultService.createResult(resultType, date, resultValue, participantId, disciplinId);
    }

    @PostMapping("/bulk")
    public List<Result> createResultsForDiscipline(@RequestBody List<Result> results) {
        return resultService.createResultsForDiscipline(results);
    }

    @GetMapping("/discipline/{disciplinId}")
    public List<Result> getAllResultsForDiscipline(@PathVariable Long disciplinId) {
        return resultService.getAllResultsForDiscipline(disciplinId);
    }

    @GetMapping("/discipline/{disciplinId}/gender")
    public List<Result> getResultsForDisciplineAndGender(@PathVariable Long disciplinId,
                                                         @RequestParam String gender) {
        return resultService.getResultsForDisciplineAndGender(disciplinId, gender);
    }

    @GetMapping("/discipline/{disciplinId}/age-range")
    public List<Result> getResultsForDisciplineAndAgeRange(@PathVariable Long disciplinId,
                                                           @RequestParam Integer minAge,
                                                           @RequestParam Integer maxAge) {
        return resultService.getResultsForDisciplineAndAgeRange(disciplinId, minAge, maxAge);
    }

    @PutMapping("/{resultId}")
    public Result updateResult(@PathVariable Long resultId,
                               @RequestParam String resultValue) {
        return resultService.updateResult(resultId, resultValue);
    }

    @DeleteMapping("/{resultId}")
    public void deleteResult(@PathVariable Long resultId) {
        resultService.deleteResult(resultId);
    }
}