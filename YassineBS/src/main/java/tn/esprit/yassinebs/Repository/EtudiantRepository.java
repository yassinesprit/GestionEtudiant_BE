package tn.esprit.yassinebs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.yassinebs.entities.Departement;
import tn.esprit.yassinebs.entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository <Etudiant,Integer> {
    public List<Etudiant> findByDepartement(Departement d);
    Etudiant findByPrenomEAndNomE(String prenomE,String nomE);

}
