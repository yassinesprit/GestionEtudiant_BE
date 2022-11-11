package tn.esprit.yassinebs.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.yassinebs.Repository.ContratRepository;
import tn.esprit.yassinebs.Repository.EtudiantRepository;
import tn.esprit.yassinebs.entities.Contrat;
import tn.esprit.yassinebs.entities.Etudiant;


import java.util.Date;
import java.util.List;

@Service
public class IContratServiceImp implements IContratService{
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        contratRepository.deleteById(idContrat);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = retrieveAllContrats();
        float result = 0 ;
        for (Contrat contrat:contrats) {
            if (startDate.after(contrat.getDateDebutContrat()) && endDate.before(contrat.getDateFinContrat())  ){
                switch (contrat.getSpecialite()) {
                    case IA:
                        result = 300 ;
                        break;
                    case RESEAUX:
                        result = 350 ;
                        break;
                    case CLOUD:
                        result = 400 ;
                        break;
                    case SECURITE:
                        result = 450 ;
                        break;
                    default:
                        result = 0;
                        break;
                }
            }
        }
        return result;
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats = retrieveAllContrats();
        Integer result = 0 ;
        for (Contrat contrat:contrats) {
            if (startDate.compareTo(contrat.getDateDebutContrat())>=0 && endDate.compareTo(contrat.getDateFinContrat())<=0) {
                result ++;
            }
        }
        return result;
    }
    @Override
    public Contrat affectContratToEtudiant2(Contrat ce, String nomE, String prenomE) {
        Etudiant etudiant = etudiantRepository.findByPrenomEAndNomE(prenomE,nomE);
        int nbcontratsnonarchivé=contratRepository.countByArchiveIsFalseAndEtudiantNomEAndEtudiantPrenomE(nomE,prenomE);
       // for (Contrat contrat:etudiant.getContrats()) {
           // if (!contrat.isArchive()){
            //    nbcontratsnonarchivé++;
           // }
        //}
        if(etudiant!=null && ce!=null && !ce.isArchive()){
            if (nbcontratsnonarchivé<5){
                ce.setEtudiant(etudiant);
                return contratRepository.save(ce);
            }
        }
        return null;
    }
}
