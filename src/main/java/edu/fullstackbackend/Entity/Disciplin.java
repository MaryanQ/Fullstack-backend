package edu.fullstackbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Disciplin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String navn;
    private String resultatType;

    @OneToMany(mappedBy = "disciplin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Resultat> resultater = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "deltager_disciplin",
            joinColumns = @JoinColumn(name = "disciplin_id"),
            inverseJoinColumns = @JoinColumn(name = "deltager_id")
    )
    private List<Deltager> deltagere = new ArrayList<>();

    public Disciplin(String navn, String resultatType) {
        this.navn = navn;
        this.resultatType = resultatType;
    }
}
