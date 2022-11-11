package tn.esprit.yassinebs.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailEquipe implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idDetailsEquipe;
    public Integer salle;
    public String thematique;
    @OneToOne(mappedBy = "detailEquipe")
    public Equipe equipe;
}
