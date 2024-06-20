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
public class Deltager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String køn;
    private int alder;
    private String klub;

    @OneToMany(mappedBy = "deltager", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Resultat> resultater = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "deltager_disciplin",
            joinColumns = @JoinColumn(name = "deltager_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplin_id")
    )
    @JsonIgnore
    private List<Disciplin> disciplin = new ArrayList<>();

    public Deltager(String name, String køn, int alder, String klub) {
        this.name = name;
        this.køn = køn;
        this.alder = alder;
        this.klub = klub;
    }
}


