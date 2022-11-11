package tn.esprit.yassinebs.Services;


import tn.esprit.yassinebs.entities.Contrat;
import tn.esprit.yassinebs.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public Etudiant addStudent(Etudiant e);
    public Etudiant updateStudent(Etudiant e);
    public Etudiant getById(Integer idEtudiant);
    public List<Etudiant> getAllStudents();
    public void removeStudent(Integer idEtudiant);
    public Etudiant addAndAssignEtudiant (Etudiant e, Integer idDepart);
    public void assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
    public Contrat affectContratToEtudiant (Contrat ce);

    public List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);

}
