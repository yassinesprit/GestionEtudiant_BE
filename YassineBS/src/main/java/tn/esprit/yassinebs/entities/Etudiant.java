package tn.esprit.yassinebs.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant ;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Contrat> contrats;
    @ManyToOne
    private Departement departement;
    @ManyToMany
    private List<Equipe> equipes;


}
