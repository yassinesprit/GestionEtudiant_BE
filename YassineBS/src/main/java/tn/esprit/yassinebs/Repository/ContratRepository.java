package tn.esprit.yassinebs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.yassinebs.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    int countByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE(String nomE,String prenomE);
}
