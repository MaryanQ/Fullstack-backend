package edu.fullstackbackend.Service;

import edu.fullstackbackend.Entity.Resultat;
import edu.fullstackbackend.Respository.ResultatRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultatService {

    private final ResultatRespository resultatRespository;

    @Autowired
    public ResultatService(ResultatRespository resultatRespository) {
        this.resultatRespository = resultatRespository;
    }

    public List<Resultat> findAllResultater() {
        return resultatRespository.findAll();
    }

    public Optional<Resultat> findResultatById(Long id) {
        return resultatRespository.findById(id);
    }

    public Resultat saveResultat(Resultat resultat) {
        return resultatRespository.save(resultat);
    }

    public Resultat updateResultat(Long id, Resultat resultatDetails) {
        Optional<Resultat> optionalResultat = resultatRespository.findById(id);

        if (optionalResultat.isPresent()) {
            Resultat resultat = optionalResultat.get();
            resultat.setResult(resultatDetails.getResult());
            resultat.setResultattype(resultatDetails.getResultattype());
            resultat.setDato(resultatDetails.getDato());
            resultat.setDeltager(resultatDetails.getDeltager());
            resultat.setDisciplin(resultatDetails.getDisciplin());
            return resultatRespository.save(resultat);
        } else {
            throw new RuntimeException("Resultat not found with id " + id);
        }
    }
    public void deleteResultat(Long id) {
        resultatRespository.deleteById(id);
    }
}
