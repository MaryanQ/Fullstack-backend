package edu.fullstackbackend.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Disciplin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String resultType;

    @OneToOne(mappedBy = "disciplin", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Result result;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    @JsonBackReference
    private Participant participant;

    public Disciplin(String name, String resultType) {
        this.name = name;
        this.resultType = resultType;
    }

    public Disciplin(String name, String resultType, Participant participant) {
        this.name = name;
        this.resultType = resultType;
        this.participant = participant;
    }
}
