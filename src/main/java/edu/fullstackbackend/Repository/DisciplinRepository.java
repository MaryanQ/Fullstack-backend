package edu.fullstackbackend.Repository;

import edu.fullstackbackend.Entity.Disciplin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinRepository extends JpaRepository<Disciplin, Long> {

}
