package edu.fullstackbackend.Respository;

import edu.fullstackbackend.Entity.Deltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface DeltagerRespository extends JpaRepository<Deltager, Long> {
}