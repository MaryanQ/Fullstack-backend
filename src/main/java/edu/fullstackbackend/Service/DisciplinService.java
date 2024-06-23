package edu.fullstackbackend.Service;

import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Repository.DisciplinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinService {

    @Autowired //
    private DisciplinRepository disciplinRepository;

    public DisciplinService(DisciplinRepository disciplinRepository) {
        this.disciplinRepository = disciplinRepository;
    }


    public List<Disciplin> getAllDisciplines() {
        return disciplinRepository.findAll();
    }

    public Disciplin saveDisciplin(Disciplin disciplin) {
        return disciplinRepository.save(disciplin);
    }
}
