package tn.esprit.yassinebs.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contrat implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private boolean archive;
    //@Transient
    //private String nom;
    @ManyToOne (cascade = CascadeType.PERSIST)
    private Etudiant etudiant;
}
