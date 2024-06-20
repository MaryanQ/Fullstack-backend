package edu.fullstackbackend.Service;

import edu.fullstackbackend.Entity.Deltager;
import edu.fullstackbackend.Respository.DeltagerRespository; // Corrected as per your instruction
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeltagerService {

    private final DeltagerRespository deltagerRespository;

    @Autowired
    public DeltagerService(DeltagerRespository deltagerRespository) {
        this.deltagerRespository = deltagerRespository;
    }

    public List<Deltager> findAllDeltagere() {
        return deltagerRespository.findAll();
    }

    public Optional<Deltager> findDeltagerById(Long id) {
        return deltagerRespository.findById(id);
    }

    public Deltager saveDeltager(Deltager deltager) {
        return deltagerRespository.save(deltager);
    }

    public Deltager updateDeltager(Long id, Deltager deltagerDetails) {
        Optional<Deltager> optionalDeltager = deltagerRespository.findById(id);

        if (optionalDeltager.isPresent()) {
            Deltager deltager = optionalDeltager.get();
            deltager.setName(deltagerDetails.getName());
            deltager.setKøn(deltagerDetails.getKøn());
            deltager.setAlder(deltagerDetails.getAlder());
            deltager.setKlub(deltagerDetails.getKlub());
            return deltagerRespository.save(deltager);
        } else {
            throw new RuntimeException("Deltager not found with id " + id);
        }
    }

    public void deleteDeltager(Long id) {
        deltagerRespository.deleteById(id);
    }
}
