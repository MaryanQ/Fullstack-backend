package edu.fullstackbackend;

import edu.fullstackbackend.Entity.Deltager;
import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Entity.Resultat;
import edu.fullstackbackend.Respository.DeltagerRespository;
import edu.fullstackbackend.Respository.DisciplinRespository;
import edu.fullstackbackend.Respository.ResultatRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class initData implements CommandLineRunner {

    private final DeltagerRespository deltagerRespository;
    private final DisciplinRespository disciplinRespository;
    private final ResultatRespository resultatRespository;

    @Autowired
    public initData(DeltagerRespository deltagerRespository, DisciplinRespository disciplinRepository, ResultatRespository resultatRepository) {
        this.deltagerRespository = deltagerRespository;
        this.disciplinRespository = disciplinRepository;
        this.resultatRespository = resultatRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize Deltager entities
        Deltager deltager1 = new Deltager("John Doe", "Male", 25, "Club A");
        Deltager deltager2 = new Deltager("Jane Smith", "Female", 28, "Club B");
        Deltager deltager3 = new Deltager("Alice Johnson", "Female", 22, "Club C");
        Deltager deltager4 = new Deltager("Bob Brown", "Male", 30, "Club A");
        Deltager deltager5 = new Deltager("Charlie Green", "Male", 27, "Club B");
        Deltager deltager6 = new Deltager("Diana White", "Female", 24, "Club C");
        Deltager deltager7 = new Deltager("Eve Black", "Female", 26, "Club A");
        Deltager deltager8 = new Deltager("Frank Blue", "Male", 23, "Club B");
        Deltager deltager9 = new Deltager("Grace Yellow", "Female", 29, "Club C");
        Deltager deltager10 = new Deltager("Henry Red", "Male", 21, "Club A");
        Deltager deltager11 = new Deltager("Ivy Purple", "Female", 31, "Club B");
        Deltager deltager12 = new Deltager("Jack Orange", "Male", 32, "Club C");

        deltagerRespository.saveAll(Arrays.asList(deltager1, deltager2, deltager3, deltager4, deltager5, deltager6, deltager7, deltager8, deltager9, deltager10, deltager11, deltager12));

        // Initialize Disciplin entities
        Disciplin disciplin1 = new Disciplin("100m Dash", "Time");
        Disciplin disciplin2 = new Disciplin("Long Jump", "Distance");
        Disciplin disciplin3 = new Disciplin("High Jump", "Height");
        Disciplin disciplin4 = new Disciplin("Marathon", "Time");

        disciplinRespository.saveAll(Arrays.asList(disciplin1, disciplin2, disciplin3, disciplin4));

        // Initialize Resultat entities
        Resultat resultat1 = new Resultat("10.5", "Time", LocalDate.of(2024, 6, 1), deltager1, disciplin1);
        Resultat resultat2 = new Resultat("7.8", "Distance", LocalDate.of(2024, 6, 2), deltager2, disciplin2);
        Resultat resultat3 = new Resultat("2.1", "Height", LocalDate.of(2024, 6, 3), deltager3, disciplin3);
        Resultat resultat4 = new Resultat("2:30:00", "Time", LocalDate.of(2024, 6, 4), deltager4, disciplin4);
        Resultat resultat5 = new Resultat("11.0", "Time", LocalDate.of(2024, 6, 5), deltager5, disciplin1);
        Resultat resultat6 = new Resultat("8.1", "Distance", LocalDate.of(2024, 6, 6), deltager6, disciplin2);
        Resultat resultat7 = new Resultat("2.0", "Height", LocalDate.of(2024, 6, 7), deltager7, disciplin3);
        Resultat resultat8 = new Resultat("2:40:00", "Time", LocalDate.of(2024, 6, 8), deltager8, disciplin4);
        Resultat resultat9 = new Resultat("10.8", "Time", LocalDate.of(2024, 6, 9), deltager9, disciplin1);
        Resultat resultat10 = new Resultat("7.5", "Distance", LocalDate.of(2024, 6, 10), deltager10, disciplin2);
        Resultat resultat11 = new Resultat("2.2", "Height", LocalDate.of(2024, 6, 11), deltager11, disciplin3);
        Resultat resultat12 = new Resultat("2:35:00", "Time", LocalDate.of(2024, 6, 12), deltager12, disciplin4);

        resultatRespository.saveAll(Arrays.asList(resultat1, resultat2, resultat3, resultat4, resultat5, resultat6, resultat7, resultat8, resultat9, resultat10, resultat11, resultat12));
    }
}
