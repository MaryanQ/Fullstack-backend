package edu.fullstackbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String result;
    private String resultattype;
    private LocalDate dato;

    @ManyToOne
    @JoinColumn(name = "deltager_id")
    @JsonIgnoreProperties("resultater")
    private Deltager deltager;

    @ManyToOne
    @JoinColumn(name = "disciplin_id")
    @JsonIgnoreProperties("resultater")
    private Disciplin disciplin;

    public Resultat(String result, String resultattype, LocalDate dato, Deltager deltager, Disciplin disciplin) {
        this.result = result;
        this.resultattype = resultattype;
        this.dato = dato;
        this.deltager = deltager;
        this.disciplin = disciplin;
    }
}

