package tn.esprit.yassinebs.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.yassinebs.entities.Departement;
import tn.esprit.yassinebs.entities.Universite;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
