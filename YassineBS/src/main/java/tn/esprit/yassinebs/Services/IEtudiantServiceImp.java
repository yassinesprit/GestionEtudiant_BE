package tn.esprit.yassinebs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yassinebs.Repository.ContratRepository;
import tn.esprit.yassinebs.Repository.EquipeRepository;
import tn.esprit.yassinebs.Repository.EtudiantRepository;
import tn.esprit.yassinebs.entities.Contrat;
import tn.esprit.yassinebs.entities.Equipe;
import tn.esprit.yassinebs.entities.Etudiant;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service//cree moi un e instance (bean) de cette classe
public class IEtudiantServiceImp implements IEtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    IDepartementService iDepartementService;
    @Autowired
    IEquipeService iEquipeService;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public Etudiant addStudent(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateStudent(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(Integer idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllStudents() {
        return etudiantRepository.findAll();
    }

    @Override
    public void removeStudent(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant addAndAssignEtudiant(Etudiant e, Integer idDepart) {
        e.setDepartement(iDepartementService.retrieveDepartement(idDepart));
        return etudiantRepository.save(e);
    }

    @Override
    public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        Etudiant e=getById(etudiantId);
        if ( e != null && iDepartementService.retrieveDepartement(departementId)!=null){
        e.setDepartement(iDepartementService.retrieveDepartement(departementId));
        etudiantRepository.save(e);}
    }

    @Override
    @Transactional// si tout est bon don il commit snn il rollback
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat c = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe =equipeRepository.findById(idEquipe).orElse(null);
        if(e!=null) {
            Etudiant student = etudiantRepository.save(e);

            if (c != null && equipe != null) {
                if (student.getEquipes() != null) {
                    student.getEquipes().add(equipe);
                } else {
                    List<Equipe> equipeList = new ArrayList<>();
                    equipeList.add(equipe);
                    student.setEquipes(equipeList);
                }
                c.setEtudiant(student);
                //contratRepository.save(c);
                return etudiantRepository.save(student);
            }
        }
        return null;
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce) {
        if (ce.getEtudiant()!= null){
            Etudiant e = ce.getEtudiant();
        etudiantRepository.save(e);
        }
        return contratRepository.save(ce);

    }



    @Override
    public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
        return etudiantRepository.findByDepartement(iDepartementService.retrieveDepartement(idDepartement));
    }
}
