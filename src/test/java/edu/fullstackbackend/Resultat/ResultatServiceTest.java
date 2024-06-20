package edu.fullstackbackend.Resultat;

import edu.fullstackbackend.Entity.Deltager;
import edu.fullstackbackend.Entity.Disciplin;
import edu.fullstackbackend.Entity.Resultat;
import edu.fullstackbackend.Respository.ResultatRespository;
import edu.fullstackbackend.Service.ResultatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ResultatServiceTest {

    @InjectMocks
    private ResultatService resultatService;

    @Mock
    private ResultatRespository resultatRepository;

    private Resultat resultat;
    private Deltager deltager;
    private Disciplin disciplin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        deltager = new Deltager("John Doe", "Male", 25, "Club A");
        disciplin = new Disciplin("100m Dash", "Time");
        resultat = new Resultat("10.5", "Time", LocalDate.of(2024, 6, 1), deltager, disciplin);
    }

    @Test
    void testFindAllResultater() {
        when(resultatRepository.findAll()).thenReturn(Arrays.asList(resultat));

        List<Resultat> resultater = resultatService.findAllResultater();

        assertNotNull(resultater);
        assertEquals(1, resultater.size());
        assertEquals("10.5", resultater.get(0).getResult());
    }

    @Test
    void testFindResultatById() {
        when(resultatRepository.findById(1L)).thenReturn(Optional.of(resultat));

        Optional<Resultat> foundResultat = resultatService.findResultatById(1L);

        assertTrue(foundResultat.isPresent());
        assertEquals("10.5", foundResultat.get().getResult());
    }

    @Test
    void testSaveResultat() {
        when(resultatRepository.save(resultat)).thenReturn(resultat);

        Resultat savedResultat = resultatService.saveResultat(resultat);

        assertNotNull(savedResultat);
        assertEquals("10.5", savedResultat.getResult());
    }

    @Test
    void testUpdateResultat() {
        when(resultatRepository.findById(1L)).thenReturn(Optional.of(resultat));
        when(resultatRepository.save(resultat)).thenReturn(resultat);

        Resultat newResultatDetails = new Resultat("11.0", "Time", LocalDate.of(2024, 6, 2), deltager, disciplin);

        Resultat updatedResultat = resultatService.updateResultat(1L, newResultatDetails);

        assertNotNull(updatedResultat);
        assertEquals("11.0", updatedResultat.getResult());
    }

    @Test
    void testDeleteResultat() {
        doNothing().when(resultatRepository).deleteById(1L);

        resultatService.deleteResultat(1L);

        verify(resultatRepository, times(1)).deleteById(1L);
    }
}
