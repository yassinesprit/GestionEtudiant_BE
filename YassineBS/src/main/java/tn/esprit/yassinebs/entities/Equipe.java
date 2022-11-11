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
public class Equipe implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @JsonIgnore
    @ManyToMany(mappedBy = "equipes")
    private List<Etudiant> etudiants;
    //l'ajout bech ysir fel etudiant
    //lequipe tetzed f lattribut "equipes" f classe etudiant
    // manajmouch nzido etudiant f equipe

    @OneToOne
    public DetailEquipe detailEquipe;


}
