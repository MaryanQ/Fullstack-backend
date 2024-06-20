package edu.fullstackbackend.Respository;

import edu.fullstackbackend.Entity.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ResultatRespository extends JpaRepository<Resultat, Long> {
}