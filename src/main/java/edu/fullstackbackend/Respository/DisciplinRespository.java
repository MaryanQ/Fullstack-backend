package edu.fullstackbackend.Respository;

import edu.fullstackbackend.Entity.Disciplin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface DisciplinRespository extends JpaRepository<Disciplin, Long> {
}