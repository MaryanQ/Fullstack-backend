package edu.fullstackbackend.Service;

import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Respository.DisciplinRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinService {

    private final DisciplinRespository disciplinRespository;

    @Autowired
    public DisciplinService(DisciplinRespository disciplinRespository) {
        this.disciplinRespository = disciplinRespository;
    }

    public List<Disciplin> findAllDiscipliner() {
        return disciplinRespository.findAll();
    }

    public Optional<Disciplin> findDisciplinById(Long id) {
        return disciplinRespository.findById(id);
    }

    public Disciplin saveDisciplin(Disciplin disciplin) {
        return disciplinRespository.save(disciplin);
    }

    public Disciplin updateDisciplin(Long id, Disciplin disciplinDetails) {
        Optional<Disciplin> optionalDisciplin = disciplinRespository.findById(id);

        if (optionalDisciplin.isPresent()) {
            Disciplin disciplin = optionalDisciplin.get();
            disciplin.setNavn(disciplinDetails.getNavn());
            disciplin.setResultatType(disciplinDetails.getResultatType());
            return disciplinRespository.save(disciplin);
        } else {
            throw new RuntimeException("Disciplin not found with id " + id);
        }
    }

    public void deleteDisciplin(Long id) {
        disciplinRespository.deleteById(id);
    }
}
